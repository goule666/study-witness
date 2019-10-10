package com.goule666.study.witness.java.basic.lambda;

/**
 * @author wlnie
 * @date 2019/10/10 14:38
 * @description 名字过滤
 **/
@FunctionalInterface
public interface NameFilter {
    /**
     * 名字过滤
     *
     * @param name 姓名
     * @return true or false
     */
    boolean filter(String name);
}
