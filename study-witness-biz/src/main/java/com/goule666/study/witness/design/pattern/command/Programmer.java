package com.goule666.study.witness.design.pattern.command;

/**
 * @author wlnie
 * @date 2019/9/14 23:18
 * @description 程序员
 **/
public class Programmer {
    /**
     * 名字
     */
    private String name;

    public Programmer(String name) {
        this.name = name;
    }

    public void demand() {
        System.out.println(name + "处理一个需求");
    }

    public void bug() {
        System.out.println(name + "处理一个bug");
    }

    public void problem() {
        System.out.println(name + "处理一个线上问题");
    }
}
