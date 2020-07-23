package com.example.project.signIn;
import com.example.project.Friend;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.project.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class SignInNetworkHandlerAsyncTask extends AsyncTask<View, String, String> {
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
            Client.ois = new ObjectInputStream(Client.socket.getInputStream());
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
        stringMessage[0] = "StringMessage[0] is not quantified";

        Thread senderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boolean userNameIsOk = true;
                    String message;
                    String iAmSignUp = "I am SignIn";
                    Client.oos.writeObject(iAmSignUp);
                    message = (String) Client.ois.readObject();
                    if(message.equals("I am in SignIn method")) {
                        Client.oos.writeObject(caller);
                        Client.oos.flush();
                        Client.oos.writeObject(uNameView.getText().toString());
                        message = (String) Client.ois.readObject();
                        if (message.contains("UserName cannot be empty")) {
                            stringMessage[0] = "UserName cannot be empty";
                            userNameIsOk = false;
                        } else if (message.contains("UserName not found")) {
                            stringMessage[0] = "UserName not found";
                            userNameIsOk = false;
                        } else if (caller.equals("Password")) {
                            stringMessage[0] = "UserName is Ok";
                        }

                        if (caller.equals("Button") && userNameIsOk ) {
                            Client.oos.writeObject(pWordView.getText().toString());
                            Client.oos.flush();
                            message = (String) Client.ois.readObject();
                            if (message.contains("Your password must contain at least 5 characters")) {
                                stringMessage[0] = "Your password contains (5+) characters";
                            } else if (message.contains("The entered password is incorrect")) {
                                stringMessage[0] = "The entered password is incorrect";
                            } else {
                                stringMessage[0] = "password is Ok";
                                message =(String) Client.ois.readObject();
                                if (message.contains("Client profile available")){
                                    Client.friends =(ArrayList<Friend>) Client.ois.readObject();
                                } else{
                                    Client.friends = new ArrayList<>();
                                }
                                Client.username = uNameView.getText().toString();
                                Client.password = pWordView.getText().toString();
                            }
                        }

                        isTheWorkDoneWithTask = true;
                    }
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