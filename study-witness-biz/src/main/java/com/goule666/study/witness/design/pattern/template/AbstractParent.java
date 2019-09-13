package com.goule666.study.witness.design.pattern.template;

/**
 * @author wlnie
 * @date 2019/9/13 16:45
 * @description
 **/
public abstract class AbstractParent {

    protected void test1() {
        System.out.println("parent test1");
    }

    protected abstract void test2();

    protected final void test3() {
        System.out.println("parent test3");
    }
}
