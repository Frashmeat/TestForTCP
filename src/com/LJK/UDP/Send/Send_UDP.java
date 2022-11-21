package com.LJK.UDP.Send;

import java.io.IOException;
import java.net.*;

public class Send_UDP {
    DatagramSocket sendSocket;
    DatagramPacket data;
    public Send_UDP(int port){

        try {
            sendSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

    }
    public void send() throws IOException {
        sendSocket.send(data);
        sendSocket.close();
    }
}
