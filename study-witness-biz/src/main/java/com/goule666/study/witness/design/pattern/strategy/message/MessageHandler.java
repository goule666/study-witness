package com.goule666.study.witness.design.pattern.strategy.message;

/**
 * @author wlnie
 * @date 2019/10/15 17:17
 * @description 消息处理器接口
 **/
public interface MessageHandler {
    /**
     * 处理消息
     *
     * @param msg 源消息
     * @return 结果
     */
    String handle(String msg);
}
