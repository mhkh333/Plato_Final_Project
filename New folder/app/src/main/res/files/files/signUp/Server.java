package com.example.project.signUp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


class Client implements Serializable{
    Socket socket;
    String userName;
    String password;
    File file;
    FileInputStream fis ;
    FileOutputStream fos;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    List<Friend> friends;
    public Client(String userName){
        this.userName = userName;
    }
}
class Friend {
    String name;
    boolean hasChat;
    ArrayList<Message> chats;
}
class Message {
    String body;
    String sender;
    java.util.Date sendTime;
}


public class Server {
    static Map<String, ClientHandler> clients;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(3000);
        clients = new ConcurrentHashMap<>();
        while ( true ) {
            Socket socket = serverSocket.accept();
            ClientHandler temp = new ClientHandler( socket );
            ( new Thread( temp ) ).start();

        }

    }
}


class ClientHandler implements Runnable {

    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Client client;
    private boolean isLoggedOut = false;

    ClientHandler( Socket socket ) throws Exception {
        this.socket = socket;
        this.ois = new ObjectInputStream( socket.getInputStream() );
        this.oos = new ObjectOutputStream( socket.getOutputStream() );
    }

    @Override
    public void run() {

        try {
            while( ! isLoggedOut) {
                String message;
                Object obj ;
                message =(String) ois.readObject();
                switch (message){
                    case "I am SignUp" : signUp();break;

                }

            }


            this.signUp();
            String messageContent;
            while (true) {
                Object message = this.ois.readObject();
                if (message instanceof String){
                    messageContent = (String) message;
                    System.out.println(messageContent );
                }
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }

    public void signUp () {
        try {
            ///////////////////////////////////////////////should change into android (user validation)
            boolean isUsernameOk = false;
            Object obj ;
            String username = "";
            String caller = "";
            this.oos.writeObject("I am in SignUp method");
            caller =(String) this.ois.readObject();
            obj = this.ois.readObject();
            if(obj instanceof String) {
                username = (String) obj;
            }
            if (Server.clients.containsKey(username)) {
                String errorMessage = "err: UserName already exists... please enter another one: ";
                this.oos.writeObject(errorMessage);
            } else {
                String okMessage = "OK: Username was OK.";
                this.oos.writeObject(okMessage);
                isUsernameOk = true;
            }
            boolean isPasswordOk = false;
            String passWord = "";
            if(caller.contains("Password")){
                return;
            }
            else {
                obj = this.ois.readObject();
                if (obj instanceof String) {
                    passWord = (String) obj;
                }
                if (passWord.length()<5) {
                    String errorMessage = "err: Your password must contain at least 5 characters"
                            +"... please enter another one: ";
                    this.oos.writeObject(errorMessage);
                    return;
                } else {
                    //this.oos.writeObject(okMessage);
                    isPasswordOk = true;
                }
            }

            Server.clients.put(username, this);
            System.out.println("User " + username + " Connected!");
            /////////////////////////////////////////////////////////////////////////////end of (user validation)
            client = new Client(username);
            boolean isFileEmpty = false;
            try {
                client.file = new File(username+".txt");
                client.file.createNewFile();
                client.userName = username;
                client.password = passWord;
                client.friends = new ArrayList<>();
                try {
                    //client.fis = new FileInputStream(client.file);   /// Nokte : client E ke taze sakhte shode niaz be fis va ois nadare
                    client.fis = new FileInputStream(client.file);
                    //client.ois = new ObjectInputStream(client.fis);
                    client.ois = new ObjectInputStream(client.fis);
                } catch (IOException e) {
                    e.printStackTrace();
                    isFileEmpty = true;
                }
                client.fos = new FileOutputStream(client.file);
                client.oos = new ObjectOutputStream(client.fos);
                client.socket = this.socket;
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.oos.writeObject("Password is Ok");
            String messageContent;
//            while (true) {
//                Object message = this.ois.readObject();
//                if (message instanceof String){
//                    messageContent = (String) message;
//                    System.out.println(messageContent );
//                }
//            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}