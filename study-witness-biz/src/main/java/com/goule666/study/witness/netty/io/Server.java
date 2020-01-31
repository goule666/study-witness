package com.goule666.study.witness.netty.io;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author wlnie
 * @date 2020/1/31 21:57
 * @description 服务端
 **/
public class Server {

    private ServerSocket serverSocket;

    private ExecutorService executorService;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("server start success. the port is : " + port);

            //创建线程池
            ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("pool-socket-handler-%d").build();
            executorService = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10000), threadFactory);
        } catch (IOException e) {
            System.out.println("server start fail. please check , the reason is " + e);
        }
    }

    public void start() {
        new Thread(this::start0).start();
    }

    private void start0() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Thread name : " + Thread.currentThread().getName() + ", server receive connect, please handle");

                executorService.execute(() -> {
                    SocketHandler.handle(socket);
                });
            } catch (IOException e) {
                System.out.println("server accept error , please check , thre reason is " + e);
            }
        }
    }
}
