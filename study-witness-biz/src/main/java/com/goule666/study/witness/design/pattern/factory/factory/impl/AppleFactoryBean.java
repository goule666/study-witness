package com.goule666.study.witness.design.pattern.factory.factory.impl;

import com.goule666.study.witness.design.pattern.factory.factory.FactoryBean;
import com.goule666.study.witness.design.pattern.factory.product.Fruit;
import com.goule666.study.witness.design.pattern.factory.product.impl.Apple;

/**
 * @author wlnie
 * @date 2019/10/16 15:59
 * @description 生成水果的工厂
 **/
public class AppleFactoryBean implements FactoryBean {
    /**
     * Return an instance (possibly shared or independent) of the object
     * managed by this factory.
     *
     * @return an instance of the bean
     */
    @Override
    public Fruit getObject() {
        return new Apple();
    }
}
