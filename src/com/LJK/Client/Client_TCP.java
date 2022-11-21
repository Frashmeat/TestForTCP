package com.LJK.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_TCP {
    //服务器Socket
    int port;
    String ip;
    OutputStream toServerOut;
    InputStream fromServerIn;
    Socket serverSocket;
    public Client_TCP(){

    }
    //构造方法


    public Client_TCP(String ip,int port) throws IOException {
        this.ip = ip;
        this.port = port;
    }

    public void Connect() throws IOException {

        while(serverSocket==null||serverSocket.isClosed()){
            serverSocket = new Socket(ip,port);
            //保存服务器的输入输出流
            toServerOut = serverSocket.getOutputStream();
            fromServerIn = serverSocket.getInputStream();
            int len = 0;
            byte[] bytes = new byte[2048];
            while((len = fromServerIn.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
                break;
            }
            serverSocket.close();
        }
    }
}
