package com.goule666.study.witness.design.pattern.factory.product.impl;

import com.goule666.study.witness.design.pattern.factory.product.MessageMiddleware;

/**
 * @author wlnie
 * @date 2019/10/16 15:55
 * @description
 **/
public class KafkaMiddleware implements MessageMiddleware {
    /**
     * 处理消息
     *
     * @param msg msg
     */
    @Override
    public void handle(String msg) {
        System.out.println("kafka handle msg，msg：" + msg);
    }
}
