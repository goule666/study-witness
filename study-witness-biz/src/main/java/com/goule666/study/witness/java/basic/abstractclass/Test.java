package com.goule666.study.witness.java.basic.abstractclass;

import com.goule666.study.witness.entity.GlUser;

/**
 * @author wlnie
 * @date 2019/10/10 11:39
 * @description
 **/
public class Test {
    private Class clazz = getClass();

    class A11111{

    }

    public static void main(String[] args) {
        //class com.goule666.study.witness.java.basic.abstractclass.Test$1
        //匿名类
        AbstractRemoteCallBack callBack = new AbstractRemoteCallBack(){

            /**
             * test
             */
            @Override
            void test() {

            }

            /**
             * 成功
             *
             * @param data data
             */
            @Override
            public void onSuccess(Object data) {
                System.out.println("成功");
            }
        };
        callBack.onFail(new Throwable("123"));
        callBack.onSuccess("123");
        //class com.goule666.study.witness.java.basic.abstractclass.Test$A11111
        //内部类
        System.out.println(Test.A11111.class);
    }
}
