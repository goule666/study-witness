package com.goule666.study.witness.design.pattern.template;

/**
 * @author wlnie
 * @date 2019/9/13 21:36
 * @description
 **/
public class Test {
    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("com.goule666.study.witness.design.pattern.template.Test");
        Object o = clazz.newInstance();
        System.out.println(o.getClass().getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(Test.class.getClassLoader());
        System.out.println(o instanceof Test);
    }
}
