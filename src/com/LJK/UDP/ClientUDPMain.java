package com.LJK.UDP;

import com.LJK.UDP.Client.Client_UDP;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientUDPMain {
    public static void main(String[] args) {
        try {
            Client_UDP cu = new Client_UDP(InetAddress.getLocalHost(),9001);
            File file = new File("E:\\BaiduCloudSrc\\test.mp4");
            cu.Connect(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
