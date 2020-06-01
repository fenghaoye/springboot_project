package com.fh.project.socket;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            Socket socket = serverSocket.accept();
            System.in.read();

            InputStream inputStream = socket.getInputStream();

            while (true) {
                byte[] bytes = new byte[1000];
                int read = inputStream.read(bytes);
                System.out.println(new String(bytes, 0, read));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
