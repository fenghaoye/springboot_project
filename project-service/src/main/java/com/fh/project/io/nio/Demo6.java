package com.fh.project.io.nio;

import java.nio.ByteBuffer;

/**
 * @Description
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/6/7 10:30 上午
 */
public class Demo6 {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }
        System.out.println("原来的buffer " + byteBuffer.position() + "  " + byteBuffer.limit() + " " + byteBuffer.capacity());

        ByteBuffer newByteBuffer = byteBuffer.slice();
        System.out.println("新的buffer " + newByteBuffer.position() + "  " + newByteBuffer.limit() + " " + newByteBuffer.capacity());

        byteBuffer.position(2);
        byteBuffer.limit(8);
        ByteBuffer newByteBuffer2 = byteBuffer.slice();
        System.out.println("新的buffer2 " + newByteBuffer2.position() + "  " + newByteBuffer2.limit() + " " + newByteBuffer2.capacity());

        for (int i = 0; i < newByteBuffer2.capacity(); i++) {
            byte b = byteBuffer.get();
            newByteBuffer2.put((byte) (b * 2));
        }

        byteBuffer.flip();
        while (byteBuffer.remaining() > 0) {
            System.out.println(byteBuffer.get());
        }

    }
}
