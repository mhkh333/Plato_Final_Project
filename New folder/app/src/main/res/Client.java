package com.example.project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Client {
    public static ObjectInputStream ois ;
    public static ObjectOutputStream oos;
    /*public static DataInputStream ois ;
    public static DataOutputStream oos;*/
    public static Socket socket ;
    public static ArrayList<Friend> friends;
    public static String username;
    public static String password;

}
