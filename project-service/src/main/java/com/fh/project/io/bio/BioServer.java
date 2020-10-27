package com.fh.project.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/6/6 10:30 下午
 */
public class BioServer {


    ServerSocket serverSocket;

    public BioServer() {
        try {
            serverSocket = new ServerSocket(9090);
            while (true){
                Socket accept = serverSocket.accept();
                System.out.println(accept.getRemoteSocketAddress().toString()+"来连接了");
                new Thread(new BioServerHandler(accept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket !=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new BioServer();
    }
}
