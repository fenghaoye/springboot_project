package com.fh.project.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/6/6 10:53 下午
 */
public class BioClient2 {

    Socket socket;

    public BioClient2() {

        OutputStream outputStream = null;
        try {
            socket = new Socket("localhost",9090);
            new Thread(new BioClientHandler(socket)).start(); // 循环读服务器向客户端返回数据
            outputStream = socket.getOutputStream();
            Scanner in = new Scanner(System.in);
            while (true){
                String s = in.nextLine();
                if(s.trim().endsWith("by")){
                    break;
                }else {
                    outputStream.write(s.getBytes());
                    outputStream.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BioClient2();
    }
}
