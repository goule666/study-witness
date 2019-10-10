package com.goule666.study.witness.java.basic.abstractclass;

/**
 * @author wlnie
 * @date 2019/10/10 11:34
 * @description 调用成功回调函数
 **/
public interface CallBack<T> {
    /**
     * 成功
     *
     * @param data data
     */
    void onSuccess(T data);

    /**
     * 失败
     *
     * @param e 异常
     */
    void onFail(Throwable e);

}
