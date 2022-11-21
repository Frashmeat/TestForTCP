package com.LJK.UDP;

import com.LJK.UDP.Server.Server_UDP;

import java.io.IOException;
import java.net.SocketException;

public class ServerUDPMain {
    public static void main(String[] args) {
        try {
            Server_UDP su = new Server_UDP(8999);
            su.Server();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
