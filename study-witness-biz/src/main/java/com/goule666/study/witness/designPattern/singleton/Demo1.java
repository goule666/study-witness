package com.goule666.study.witness.designPattern.singleton;

/**
 * @author wlnie
 * @date 2019/9/8 20:37
 * @description 饿汉式
 **/
public class Demo1 {
    private Demo1() {
    }

    private static Demo1 demo1 = new Demo1();

    public static Demo1 getDemo() {
        return demo1;
    }

}
