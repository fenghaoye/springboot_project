package com.fh.project.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class SocketDemo {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 8081);

            OutputStream outputStream = socket.getOutputStream();

            int i = 0;
            while (true) {
                System.out.println(i++);
                outputStream.write("123".getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
