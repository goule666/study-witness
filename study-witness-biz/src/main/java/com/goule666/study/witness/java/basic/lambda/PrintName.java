package com.goule666.study.witness.java.basic.lambda;

/**
 * @author wlnie
 * @date 2019/10/10 14:43
 * @description 输出名字
 **/
@FunctionalInterface
public interface PrintName {
    /**
     * 输出符合条件的名字
     *
     * @param name 名字
     */
    void execute(String name);
}
