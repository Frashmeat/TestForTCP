package com.LJK.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_TCP implements Runnable{
    //服务器线程
    public Thread thread;
    private int port = 8666;
    private ServerSocket ss;
    private Socket client;
    private OutputStream toClientOut;
    private InputStream fromClientIn;
    //构造方法
    public Server_TCP() {
        thread = new Thread(this);
    }

    public Server_TCP(int port) {
        this.port = port;
    }

    public void Server() throws IOException {
        //开启服务器
        ss = new ServerSocket(port);
         //服务器等待链接
        client = ss.accept();

         //服务器获取链接客服端的Socket
        toClientOut = client.getOutputStream();
        //保存客户端信息
        fromClientIn = client.getInputStream();
//        File image = new File("C:\\Users\\sluttyname\\Pictures\\screenshots\\khl20220829001132849.png");
//        FileInputStream fin = new FileInputStream(image);
//        int len = 0;
//        byte[] bytes = new byte[1024];
//        while((len = fin.read(bytes))!=-1){
//            //向客服端发送
//            toClientOut.write(bytes);
//        }

    }
    public void sendToClient(File file) throws IOException {
        if(!file.exists()) return;
        FileInputStream fin = new FileInputStream(file);
        int len = 0;
        byte[] bytes = new byte[2042];
        while((len = fin.read(bytes))!=-1){
            toClientOut.write(bytes);
        }
    }
    public void close() throws IOException {
        this.ss.close();
    }
    public void sendToClient(String chat) throws IOException {
        toClientOut.write(chat.getBytes());
    }
    @Override
    public void run() {
        System.out.println("Server_TCP has Started");
        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                Server_TCP st =  new Server_TCP();
                st.Server();
                String send = sc.nextLine();
                st.sendToClient(send);
                st.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
