package com.goule666.study.witness.design.pattern.adapter;

/**
 * @author wlnie
 * @date 2019/10/13 16:31
 * @description 日本的变压器的处理器 输出110V
 **/
public interface JapanVoltHandler {

    /**
     * 给定一个电压 输出当前国家对应的电压
     *
     * @param volt 输入
     * @return 输出
     */
    Integer japanConvert(Integer volt);

}
