package com.LJK.Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_TCP implements Runnable{
    Socket serverSocket;
    public Client_TCP(){

    }

    public Client_TCP(Socket serverSocket){
        this.serverSocket = serverSocket;
    }

    public Client_TCP(int port) throws IOException {
        serverSocket = new Socket(InetAddress.getLocalHost().getHostAddress(),port);
    }

    public void Connect(){

    }
    @Override
    public void run() {
        new Client_TCP().Connect();

    }
}
