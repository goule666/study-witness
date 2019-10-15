package com.goule666.study.witness.design.pattern.strategy.message.impl;

import com.goule666.study.witness.design.pattern.strategy.message.MessageHandler;
import com.goule666.study.witness.design.pattern.strategy.message.annotation.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wlnie
 * @date 2019/10/15 17:20
 * @description 清空货物消息处理器
 **/
@Slf4j
@Component
@MessageType(value = "clear")
public class ClearMessageHandler implements MessageHandler {
    /**
     * 处理消息
     *
     * @param msg 源消息
     * @return 结果
     */
    @Override
    public String handle(String msg) {
        System.out.println(msg);
        return "==>清空货物消息处理器（ClearMessageHandler）成功处理了消息，msg：" + msg;
    }
}
