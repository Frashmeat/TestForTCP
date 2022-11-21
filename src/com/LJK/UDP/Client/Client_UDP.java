package com.LJK.UDP.Client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client_UDP {
    InetAddress address;
    int port;
    public Client_UDP(InetAddress address,int port){
        this.address = address;
        this.port = port;
    }
    public void Connect() throws IOException {
        while(true){
            Scanner sc = new Scanner(System.in);
            String message = sc.nextLine();
            int len = message.getBytes().length;
            DatagramPacket data = new DatagramPacket(message.getBytes(),len,address,port);
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.send(data);
        }
    }
    public void Connect(File file) throws IOException {
       while(true){
           DatagramSocket datagramSocket = new DatagramSocket();
           FileInputStream fin = new FileInputStream(file);
           byte[] bytes = new byte[fin.available()];

           fin.read(bytes);

           DatagramPacket data = new DatagramPacket(bytes,0,bytes.length,address,port);


           datagramSocket.send(data);
           datagramSocket.close();
           fin.close();
       }
    }
}
