package com.goule666.study.witness.design.pattern.singleton;

/**
 * @author wlnie
 * @date 2019/9/8 20:47
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        Demo5 demo5 = Demo5.INSTANCE;
        Demo4 demo4 = Demo4.getDemo();
        Demo3 demo3 = Demo3.getDemo();
        Demo2 demo2 = Demo2.getDemo();
        Demo1 demo1 = Demo1.getDemo();
    }
}
