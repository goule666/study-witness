package com.goule666.study.witness.design.pattern.template;

/**
 * @author wlnie
 * @date 2019/9/13 16:46
 * @description
 **/
public class Son extends AbstractParent {

    @Override
    protected void test2() {
        System.out.println("son test2");

    }


    public static void main(String[] args) {
        AbstractParent son = new Son();
        son.test1();
        son.test2();
        son.test3();
    }

}
