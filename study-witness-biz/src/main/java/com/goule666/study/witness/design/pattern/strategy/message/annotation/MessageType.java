package com.goule666.study.witness.design.pattern.strategy.message.annotation;

import java.lang.annotation.*;

/**
 * @author wlnie
 * @date 2019/10/15 17:21
 * @description 消息类型注解
 * 注意：@Inherited注解可以让继承的子类也拥有这个注解。spring 开启事务 会导致从spring环境中获取的处理器类（代理类）没有这个注解
 **/
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageType {
    String value();
}
