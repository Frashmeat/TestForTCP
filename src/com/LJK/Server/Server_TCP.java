package com.LJK.Server;

import java.io.IOException;
import java.io.OutputStream;
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

        String send = "Start connecting";
        toClientOut.write(send.getBytes());


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
