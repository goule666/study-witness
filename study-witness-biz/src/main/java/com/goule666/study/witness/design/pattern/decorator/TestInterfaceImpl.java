package com.goule666.study.witness.design.pattern.decorator;

/**
 * @author wlnie
 * @date 2019/9/14 15:00
 * @description 待装饰的原类
 **/
public class TestInterfaceImpl implements TestInterface {
    @Override
    public void method() {
        System.out.println("原方法");
    }
}
