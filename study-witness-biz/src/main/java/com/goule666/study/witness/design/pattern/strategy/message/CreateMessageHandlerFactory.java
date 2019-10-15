package com.goule666.study.witness.design.pattern.strategy.message;

import com.goule666.study.witness.design.pattern.strategy.message.annotation.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wlnie
 * @date 2019/10/15 17:28
 * @description 创建消息处理器 简单工厂类 获取消息处理器
 **/
@Slf4j
@Component
public class CreateMessageHandlerFactory {

    /**
     * 存放所有的策略
     */
    private Map<String, Object> map;

    @Resource
    private ApplicationContext context;

    /**
     * The PostConstruct annotation is used on a method that needs to be executed
     * after dependency injection is done to perform any initialization.
     * 这个注解被用来在依赖注入完成之后执行一些初始化操作
     */
    @PostConstruct
    private void init() {
        this.map = new HashMap<>(16);
        Map<String, Object> matchingBeans = context.getBeansWithAnnotation(MessageType.class);
        if (!matchingBeans.isEmpty()) {
            matchingBeans.forEach((k, v) -> {
                map.put(v.getClass().getAnnotation(MessageType.class).value(), v);
            });
        }
    }

    /**
     * 获取消息处理器
     *
     * @param msg 消息
     * @return handler
     * @throws Exception exception
     */
    public MessageHandler getHandler(String msg) throws Exception {
        if (!map.isEmpty()) {
            MessageHandler handler = (MessageHandler) map.get(msg);
            if (handler == null) {
                throw new Exception("没有相关消息处理器");
            }
            return handler;
        }
        throw new Exception("没有相关消息处理器");
    }
}
