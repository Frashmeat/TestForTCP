package com.LJK.UDP.Receive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive_UDP {
    DatagramSocket receiveSocket;
    DatagramPacket data;
    public Receive_UDP(){

    }

    public Receive_UDP(DatagramSocket receiveSocket, DatagramPacket data) {
        this.receiveSocket = receiveSocket;
        this.data = data;
    }
    public void Receive() throws IOException {
        receiveSocket.receive(data);
        byte[] bytes = data.getData();
        int len = data.getLength();
        System.out.println(new String(bytes,0,len));
    }
}
