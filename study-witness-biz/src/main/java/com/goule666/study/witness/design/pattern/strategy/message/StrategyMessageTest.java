package com.goule666.study.witness.design.pattern.strategy.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wlnie
 * @date 2019/10/15 18:36
 * @description
 **/
@Component
public class StrategyMessageTest {

    @Autowired
    private CreateMessageHandlerFactory createMessageHandlerFactory;

    public void test(String msg) throws Exception {
        MessageHandler handler = createMessageHandlerFactory.getHandler(msg);
        System.out.println(handler.handle(msg));
    }
}
