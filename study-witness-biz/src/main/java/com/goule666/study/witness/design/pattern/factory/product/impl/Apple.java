package com.goule666.study.witness.design.pattern.factory.product.impl;

import com.goule666.study.witness.design.pattern.factory.product.Fruit;

/**
 * @author wlnie
 * @date 2019/10/16 16:23
 * @description 苹果
 **/
public class Apple implements Fruit {
    /**
     * 是否甜
     */
    @Override
    public void isSweet() {
        System.out.println("苹果不甜.");
    }
}
