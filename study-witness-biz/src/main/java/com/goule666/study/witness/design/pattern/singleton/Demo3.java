package com.goule666.study.witness.design.pattern.singleton;

/**
 * @author wlnie
 * @date 2019/9/8 20:41
 * @description double check
 **/
public class Demo3 {
    private Demo3() {
    }

    private static Demo3 demo3;

    public static Demo3 getDemo() {
        if (demo3 == null) {
            synchronized (Demo3.class) {
                if (demo3 == null) {
                    return new Demo3();
                }
            }
        }
        return demo3;
    }
}
