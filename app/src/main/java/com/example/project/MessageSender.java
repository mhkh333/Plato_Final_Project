//package com.example.project;
//
//import android.os.AsyncTask;
//
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class MessageSender extends AsyncTask<Void,Void,Void> {
//
//    Socket socket;
//    DataOutputStream dos;
//    PrintWriter pw;
//
//    @Override
//    protected Void doInBackground(Void... voids)
//    {
//        try {
//            socket = new Socket("192.168.1.177",7800);
//            pw = new PrintWriter(socket.getOutputStream());
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}