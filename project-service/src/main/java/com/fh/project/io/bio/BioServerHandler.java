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
public class BioServerHandler implements Runnable {

    Socket socket;

    public BioServerHandler(Socket socket) {
        System.out.println("服务器获得socket");
        this.socket = socket;
    }


    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            System.out.println("服务器开始读数据");
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            int count = 0;
            String content = null;
            byte[] bytes = new byte[1024];
            while ((count = inputStream.read(bytes)) != -1) {
                String line = new String(bytes, 0, count, "utf-8");
                System.out.println(line);
                content = line.equalsIgnoreCase("sj") ? new SimpleDateFormat("yyyy-MM-dd").format(new Date()) : "你发的啥？";
                System.out.println("服务端回复"+content);
                outputStream.write(content.getBytes());
                outputStream.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
        }
    }
}
