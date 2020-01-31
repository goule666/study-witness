package com.goule666.study.witness.netty.io;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author wlnie
 * @date 2020/1/31 21:57
 * @description socket处理器
 **/
public class SocketHandler {

    public static void handle(@NotNull Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();

            byte[] data = new byte[1024];
            int len;
            while ((len = inputStream.read(data)) != -1) {
                System.out.println("Thread name : " + Thread.currentThread().getName() + ", server receive message, the message is : " + new String(data, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
