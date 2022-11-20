package com.LJK.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_TCP implements Runnable{
    //服务器Socket
    public Socket serverSocket;
    OutputStream toServerOut;
    InputStream fromServerIn;
    public Client_TCP(){

    }
    //构造方法
    public Client_TCP(Socket serverSocket){
        this.serverSocket = serverSocket;
    }

    public Client_TCP(int port) throws IOException {
        serverSocket = new Socket(InetAddress.getLocalHost().getHostAddress(),port);
    }

    public void Connect() throws IOException {
        //保存服务器的输入输出流
        toServerOut = serverSocket.getOutputStream();
        fromServerIn = serverSocket.getInputStream();
    }
    @Override
    public void run() {
        try {
            //创建并开始链接
            new Client_TCP(8666).Connect();
            //读取数据
            int len = 0;
            byte[] bytes = new byte[2048];
            while((len = fromServerIn.read(bytes))!=-1){
                //输出数据
                System.out.println(new String(bytes,0,len));
            }

            serverSocket.close();
            toServerOut.close();
            fromServerIn.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
