package com.goule666.study.witness.design.pattern.adapter;

/**
 * @author wlnie
 * @date 2019/10/13 16:46
 * @description 变压处理器
 **/
public interface VoltHandler {
    /**
     * 给定一个电压 输出对应的国家的电压
     *
     * @param volt 给定的电压
     * @return 转化之后的电压
     */
    Integer convert(Integer volt);
}
