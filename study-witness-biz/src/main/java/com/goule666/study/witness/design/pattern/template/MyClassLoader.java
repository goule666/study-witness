package com.goule666.study.witness.design.pattern.template;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wlnie
 * @date 2019/9/13 21:43
 * @description
 **/
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
        InputStream is = getClass().getResourceAsStream(fileName);
        if (is == null) {
            return super.loadClass(name);
        }
        try {
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Test test = new Test();
        ClassLoader classLoader = new MyClassLoader();
        Class<?> clazz = classLoader.loadClass("com.goule666.study.witness.design.pattern.template.Test");
        Object o = clazz.newInstance();
        System.out.println(o.getClass().getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(test.getClass().getClassLoader());
        System.out.println(o instanceof Test);

    }

}
