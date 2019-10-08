package com.goule666.study.witness.design.pattern.chain;

/**
 * @author wlnie
 * @date 2019/10/8 23:36
 * @description 获取水站抽象类
 **/
public interface StationHandler {

    /**
     * 获取水站
     *
     * @param stationHandlerChain 链
     * @return 水站名称
     */
    String getStation(StationHandlerChain stationHandlerChain);
}
