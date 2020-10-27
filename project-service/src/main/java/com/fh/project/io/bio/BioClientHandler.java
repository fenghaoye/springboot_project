package com.fh.project.io.bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/6/6 10:42 下午
 */
public class BioClientHandler implements Runnable {

    Socket socket;

    public BioClientHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        InputStream inputStream = null;

        try {
            inputStream = socket.getInputStream();
            int count = 0;
            String content = null;
            byte[] bytes = new byte[1024];
            while ((count = inputStream.read(bytes)) != -1) {
                String line = new String(bytes, 0, count, "utf-8");
                System.out.println(line);
            }

        } catch (Exception e) {
                e.printStackTrace();
        } finally {
            // 关闭连接
        }
    }
}
