package com.goule666.study.witness.design.pattern.factory;

import com.goule666.study.witness.design.pattern.factory.factory.FactoryBean;
import com.goule666.study.witness.design.pattern.factory.factory.impl.AppleFactoryBean;
import com.goule666.study.witness.design.pattern.factory.factory.impl.KafkaFactoryBean;
import com.goule666.study.witness.design.pattern.factory.product.Fruit;
import com.goule666.study.witness.design.pattern.factory.product.MessageMiddleware;

/**
 * @author wlnie
 * @date 2019/10/16 15:51
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        //工厂类：FactoryBean 产品类：Fruit、MessageMiddleware
        //工厂实现类：AppleFactoryBean、KafkaFactoryBean
        //产品实现类：Apple、KafkaMiddleware
        FactoryBean factoryBean = new KafkaFactoryBean();
        MessageMiddleware messageMiddleware = (MessageMiddleware) factoryBean.getObject();
        messageMiddleware.handle("123");

        factoryBean = new AppleFactoryBean();
        Fruit apple = (Fruit)factoryBean.getObject();
        apple.isSweet();
    }
}
