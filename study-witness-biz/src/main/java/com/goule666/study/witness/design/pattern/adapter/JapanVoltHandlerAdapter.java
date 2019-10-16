package com.goule666.study.witness.design.pattern.adapter;

/**
 * @author wlnie
 * @date 2019/10/13 16:26
 * @description 日本的变压器的适配器实现类
 **/
public class JapanVoltHandlerAdapter implements VoltHandlerAdapter {
    /**
     * given a handler instance. return whether or not this{@code VoltHandlerAdapter} can support it.
     *
     * @param voltHandler handler object to check
     * @return whether or not this object can user the given handler
     */
    @Override
    public boolean supports(Object voltHandler) {
        return voltHandler instanceof JapanVoltHandler;
    }

    /**
     * use the given handler to handle this request
     *
     * @param volt        给出的电压
     * @param voltHandler 给定的处理器
     * @return 转换之后的电压
     */
    @Override
    public Integer handler(Integer volt, Object voltHandler) {
        return ((JapanVoltHandler) voltHandler).japanConvert(volt);
    }
}
