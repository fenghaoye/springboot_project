package com.fh.project.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/6/7 8:17 上午
 */
public class Demo4 {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/fenghao/sources/springboot_project/project-service/read");
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/fenghao/sources/springboot_project/project-service/write");

            FileChannel in = fileInputStream.getChannel();
            FileChannel out = fileOutputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(100);

            while (true){
                byteBuffer.clear();// 注释了这一行就死循环了，因此后面再read时，limit=position 返回0
                int read = in.read(byteBuffer);
                System.out.println("写的数据"+read);
                if(read == -1){
                    break;
                }
                byteBuffer.flip(); // mark = -1
                out.write(byteBuffer);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
