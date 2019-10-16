package com.goule666.study.witness.design.pattern.factory.factory;

/**
 * @author wlnie
 * @date 2019/10/16 15:34
 * @description 消息中间件工厂bean
 **/
public interface FactoryBean<T> {
    /**
     * Return an instance (possibly shared or independent) of the object
     * managed by this factory.
     *
     * @return an instance of the bean
     */
    T getObject();
}
