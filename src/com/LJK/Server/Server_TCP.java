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
        thread = new Thread(this);
        this.port = port;
    }

    public void Server() throws IOException {
        //开启服务器(本机ip：port)
        ss = new ServerSocket(port);
        //服务器等待链接
        //服务器获取链接客服端的Socket
        client = ss.accept();

        //保存客户端的输入输出流
        toClientOut = client.getOutputStream();
        fromClientIn = client.getInputStream();

        //test
//        File image = new File("C:\\Users\\sluttyname\\Pictures\\screenshots\\khl20220829001132849.png");
//        FileInputStream fin = new FileInputStream(image);
//        int len = 0;
//        byte[] bytes = new byte[1024];
//        while((len = fin.read(bytes))!=-1){
//            //向客服端发送
//            toClientOut.write(bytes);
//        }

    }
    //发送文件
    public void sendToClient(File file) throws IOException {
        if(!file.exists()) return;
        FileInputStream fin = new FileInputStream(file);
        int len = 0;
        byte[] bytes = new byte[2042];
        while((len = fin.read(bytes))!=-1){
            toClientOut.write(bytes);
        }
    }
    //发送字符串
    public void sendToClient(String chat) throws IOException {
        toClientOut.write(chat.getBytes());
    }
    //关闭服务器
    public void close() throws IOException {
        this.ss.close();
    }


    @Override
    public void run() {
        System.out.println("Server_TCP has Started");
        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                //询问当前是否有客服端链接
                if(client == null) {
                    System.out.println("client is null ");
                }
                //创建服务器
                Server_TCP st =  new Server_TCP();
                //开启服务器
                st.Server();
                //客服端已链接
                System.out.println("client is connecting");
                //准备要发送的信息
                String send = sc.nextLine();
                //发送
                st.sendToClient(send);
                //关闭服务器
                st.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
