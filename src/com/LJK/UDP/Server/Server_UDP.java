package com.LJK.UDP.Server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server_UDP {
    //服务器Socket
    DatagramSocket ds;
    public Server_UDP(int port) throws SocketException {
        ds = new DatagramSocket(port);
    }
    public void Server() throws IOException {
        while(true){
            byte[] bytes = new byte[2048];
            DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length);

            ds.receive(dp);

            byte[] bytes1 = new byte[2048];
            bytes1 = dp.getData();
//            String message = new String(dp.getData(),0, dp.getLength());
//            System.out.println(message);
            File file = new File("E:\\BaiduCloudSrc\\t1.mp4");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes1,0, dp.getLength());
            }
        }
    }
