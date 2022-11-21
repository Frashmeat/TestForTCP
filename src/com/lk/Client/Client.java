package com.lk.Client;

import com.LJK.Client.Client_TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable{


        public Socket serverSocket;
        OutputStream toServerOut;
        InputStream fromServerIn;
        public Client(){

        }
        //构造方法
        public Client(Socket serverSocket){
            this.serverSocket = serverSocket;
        }

        public Client(int port) throws IOException {
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
                new com.LJK.Client.Client_TCP(8666).Connect();
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

}
