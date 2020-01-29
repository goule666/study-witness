package com.goule666.study.witness.netty.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wlnie
 * @date 2020/1/29 20:10
 * @description 服务端
 **/
public class Server {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4201);
        while (true) {
            final Socket socket = serverSocket.accept();
            executorService.execute(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = inputStream.read(bytes)) != -1) {
                        String message = new String(bytes, 0, len);
                        System.out.println(Thread.currentThread().getName() + " , 服务端收到客户端的消息：" + message);
                        socket.getOutputStream().write(bytes);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
    }
}
