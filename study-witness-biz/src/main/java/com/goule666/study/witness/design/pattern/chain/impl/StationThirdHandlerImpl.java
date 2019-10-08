package com.goule666.study.witness.design.pattern.chain.impl;

import com.goule666.study.witness.design.pattern.chain.StationHandler;
import com.goule666.study.witness.design.pattern.chain.StationHandlerChain;

/**
 * @author wlnie
 * @date 2019/10/8 23:35
 * @description 第三方获取水站名称
 **/
public class StationThirdHandlerImpl implements StationHandler {
    /**
     * 获取水站
     *
     * @param stationHandlerChain 链
     * @return 水站名称
     */
    @Override
    public String getStation(StationHandlerChain stationHandlerChain) {
        System.out.println("第三方获取水站成功!!!");
        stationHandlerChain.getStation();

        return "娃哈哈水站第三方2号";
    }
}
