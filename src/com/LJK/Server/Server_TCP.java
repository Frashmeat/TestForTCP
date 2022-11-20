package com.LJK.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_TCP implements Runnable{
    public Thread thread;
    private int port = 8666;
    private ServerSocket ss;
    private Socket client;
    private OutputStream toClientOut;

    public Server_TCP() {
        thread = new Thread(this);
    }

    public Server_TCP(int port) {
        this.port = port;
    }

    public void Server() throws IOException {
         ss = new ServerSocket(port);
         client = ss.accept();
        toClientOut = client.getOutputStream();
        File image = new File("C:\\Users\\sluttyname\\Pictures\\screenshots\\khl20220829001132849.png");
        FileInputStream fin = new FileInputStream(image);
        int len = 0;
        byte[] bytes = new byte[1024];
        while((len = fin.read(bytes))!=-1){
            toClientOut.write(bytes);
        }

    }
    @Override
    public void run() {
        System.out.println("Server_TCP has Started");
        try {
            new Server_TCP().Server();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
