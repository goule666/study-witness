package com.goule666.study.witness.design.pattern.factory.factory.impl;

import com.goule666.study.witness.design.pattern.factory.product.impl.KafkaMiddleware;
import com.goule666.study.witness.design.pattern.factory.product.MessageMiddleware;
import com.goule666.study.witness.design.pattern.factory.factory.FactoryBean;

/**
 * @author wlnie
 * @date 2019/10/16 15:41
 * @description 卡夫卡消息中间件
 **/
public class KafkaFactoryBean implements FactoryBean {

    private MessageMiddleware messageMiddleware;

    {
        messageMiddleware = new KafkaMiddleware();
    }

    /**
     * Return an instance (possibly shared or independent) of the object
     * managed by this factory.
     *
     * @return an instance of the bean
     */
    @Override
    public MessageMiddleware getObject() {
        return this.messageMiddleware;
    }
}
