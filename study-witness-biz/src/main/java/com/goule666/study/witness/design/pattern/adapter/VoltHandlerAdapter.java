package com.goule666.study.witness.design.pattern.adapter;

/**
 * @author wlnie
 * @date 2019/10/13 16:25
 * @description 变压器的适配器接口
 **/
public interface VoltHandlerAdapter {
    /**
     * given a handler instance. return whether or not this{@code VoltHandlerAdapter} can support it.
     *
     * @param voltHandler handler object to check
     * @return whether or not this object can user the given handler
     */
    boolean supports(Object voltHandler);

    /**
     * use the given handler to handle this request
     *
     * @param volt        给出的电压
     * @param voltHandler 给定的处理器
     * @return 转换之后的电压
     */
    Integer handler(Integer volt, Object voltHandler);
}
