package com.goule666.study.witness.java.basic.abstractclass;

/**
 * @author wlnie
 * @date 2019/10/10 11:37
 * @description 远程调用回调
 **/
public abstract class AbstractRemoteCallBack<T> implements CallBack<T> {


    /**
     * 失败的统一处理方式
     *
     * @param e 异常
     */
    @Override
    public void onFail(Throwable e) {
        System.out.println(e.getMessage());
    }

    /**
     * test
     */
    abstract void test();

}
