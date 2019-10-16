package com.goule666.study.witness.design.pattern.factory.product;

/**
 * @author wlnie
 * @date 2019/10/16 15:50
 * @description 消息中间件接口
 **/
public interface MessageMiddleware {
    /**
     * 处理消息
     *
     * @param msg msg
     */
    void handle(String msg);
}
