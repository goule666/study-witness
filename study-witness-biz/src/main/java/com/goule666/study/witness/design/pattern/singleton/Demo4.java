package com.goule666.study.witness.design.pattern.singleton;

/**
 * @author wlnie
 * @date 2019/9/8 20:45
 * @description 静态类部类
 **/
public class Demo4 {
    private Demo4() {
    }

    private static class GetInstance {
        private static Demo4 demo4 = new Demo4();
    }

    public static Demo4 getDemo() {
        return GetInstance.demo4;
    }
}
