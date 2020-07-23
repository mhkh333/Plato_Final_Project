package com.example.project.signUp;


import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkHandlerAsyncTask extends AsyncTask<View, String, String> {
    private EditText uNameView;
    private EditText pWordView;
    boolean isTheWorkDoneWithTask = false;
    @Override
    protected String doInBackground(View... views) {
        uNameView = (EditText) views[0];
        pWordView = (EditText) views[1];


        try {
            Client.socket = new Socket("10.0.2.2",5432);
            Client.oos = new ObjectOutputStream(Client.socket.getOutputStream());
            /*Client.oos = new DataOutputStream(Client.socket.getOutputStream());*/
            Client.ois = new ObjectInputStream(Client.socket.getInputStream());
            /*Client.ois = new DataInputStream(Client.socket.getInputStream());*/

            Log.i("Socket" , "Socket connected");
            System.out.println("socket connected");

            while ( ! isTheWorkDoneWithTask) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("error in socket initializing");
            Log.i("socket","error in socket initializing");
            e.printStackTrace();
        }
        return "Done";
    }
    public String sendClientData(final String caller){

        final String[] stringMessage = new String[1];
        stringMessage[0] = "hello";

        Thread senderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boolean userNameIsOk = true;
                    String message;
                    String iAmSignUp = "I am SignUp";
                    /*Client.oos.writeObject(iAmSignUp);
                    message = (String) Client.ois.readObject();
                    if(message.equals("I am in SignUp method")){
                        Client.oos.writeObject(caller);
                        Client.oos.flush();
                        Client.oos.writeObject(uNameView.getText().toString());
                        message = (String) Client.ois.readObject();
                        if(message.contains("UserName already exists")){
                            stringMessage[0] =  "UseName already exists";
                            return;
                        }else if(message.contains("UserName cannot be empty")){
                            stringMessage[0] =  "UserName cannot be empty";
                            return;
                        }else if(caller.equals("Password")) {
                            stringMessage[0] = "UseName is Ok";
                            return;
                        }
                        Client.oos.writeObject(pWordView.getText().toString());
                        Client.oos.flush();
                        message = (String) Client.ois.readObject();*/
                    Client.oos.writeObject(iAmSignUp);
                    message = (String) Client.ois.readObject();
                    if(message.equals("I am in SignUp method")) {
                        Client.oos.writeObject(caller);
                        Client.oos.flush();
                        Client.oos.writeObject(uNameView.getText().toString());
                        message = (String) Client.ois.readObject();
                        if (message.contains("UserName already exists")) {
                            stringMessage[0] = "UseName already exists";
                            userNameIsOk = false;
                        } else if (message.contains("UserName cannot be empty")) {
                            stringMessage[0] = "UserName cannot be empty";
                            userNameIsOk = false;
                        } else if (caller.equals("Password")) {
                            stringMessage[0] = "UserName is Ok";
                        }

                        if (caller.equals("Button") && userNameIsOk ) {
                            Client.oos.writeObject(pWordView.getText().toString());
                            Client.oos.flush();
                            message = (String) Client.ois.readObject();
                            if (message.contains("err")) {
                                stringMessage[0] = "password must contain (5+) characters";
                            } else {
                                stringMessage[0] = "password is Ok";
                            }
                        }

                        isTheWorkDoneWithTask = true;
                    }
                    /*Client.oos.writeUTF(iAmSignUp);
                    message = (String) Client.ois.readUTF();
                    if(message.equals("I am in SignUp method")) {
                        Client.oos.writeUTF(caller);
                        Client.oos.flush();
                        Client.oos.writeUTF(uNameView.getText().toString());
                        message = (String) Client.ois.readUTF();
                        if (message.contains("UserName already exists")) {
                            stringMessage[0] = "UseName already exists";
                            userNameIsOk = false;
                        } else if (message.contains("UserName cannot be empty")) {
                            stringMessage[0] = "UserName cannot be empty";
                            userNameIsOk = false;
                        } else if (caller.equals("Password")) {
                            stringMessage[0] = "UserName is Ok";
                        }

                        if (caller.equals("Button") && userNameIsOk ) {
                            Client.oos.writeUTF(pWordView.getText().toString());
                            Client.oos.flush();
                            message = (String) Client.ois.readUTF();
                            if (message.contains("err")) {
                                stringMessage[0] = "password must contain (5+) characters";
                            } else {
                                stringMessage[0] = "password is Ok";
                            }
                        }

                        isTheWorkDoneWithTask = true;
                    }*/
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        senderThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stringMessage[0];
    }

}