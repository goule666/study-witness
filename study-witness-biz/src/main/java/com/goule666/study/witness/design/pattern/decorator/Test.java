package com.goule666.study.witness.design.pattern.decorator;

/**
 * @author wlnie
 * @date 2019/9/14 15:07
 * @description 装饰器模式 demo
 **/
public class Test {
    public static void main(String[] args) {
        TestInterface testInterface = new TestInterfaceImpl();
        AbstractDecoratorTest abstractDecoratorTest = new DecoratorTestA(testInterface);
        abstractDecoratorTest.method();
        ((DecoratorTestA) abstractDecoratorTest).methodA();
    }
}
