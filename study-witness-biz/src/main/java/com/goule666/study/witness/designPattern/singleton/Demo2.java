package com.goule666.study.witness.designPattern.singleton;

/**
 * @author wlnie
 * @date 2019/9/8 20:40
 * @description 懒汉式
 **/
public class Demo2 {
    private Demo2() {
    }

    private static Demo2 demo2;

    public static Demo2 getDemo() {
        if (demo2 == null) {
            return new Demo2();
        }
        return demo2;
    }
}
