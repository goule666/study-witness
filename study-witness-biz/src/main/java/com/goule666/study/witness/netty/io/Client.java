package com.goule666.study.witness.netty.io;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wlnie
 * @date 2020/1/29 21:49
 * @description
 **/
public class Client {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    Socket socket = new Socket("127.0.0.1", 4201);
                    String message = "Hello World , i am main";
                    System.out.println(Thread.currentThread().getName() + ",客户端发送：" + message);
                    socket.getOutputStream().write(message.getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
