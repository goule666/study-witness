package com.goule666.study.witness.netty.io;

/**
 * @author wlnie
 * @date 2020/1/31 21:56
 * @description 服务端启动器
 **/
public class ServerBoot {

    public static void main(String[] args) {
        Server server = new Server(4201);
        server.start();
    }
}
