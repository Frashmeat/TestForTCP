package com.LJK.UDP;

import com.lk.UDP.Client.Client_UDP;

import java.io.IOException;
import java.net.InetAddress;

public class ClientUDPMain {
    public static void main(String[] args) {
        try {
            Client_UDP cu = new Client_UDP(InetAddress.getLocalHost(),8999);
            cu.Connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
