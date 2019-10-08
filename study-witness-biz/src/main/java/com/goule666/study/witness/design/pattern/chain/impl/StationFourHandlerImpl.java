package com.goule666.study.witness.design.pattern.chain.impl;

import com.goule666.study.witness.design.pattern.chain.StationHandler;
import com.goule666.study.witness.design.pattern.chain.StationHandlerChain;

/**
 * @author wlnie
 * @date 2019/10/9 00:05
 * @description 第四方获取水站实现类
 **/
public class StationFourHandlerImpl implements StationHandler {
    /**
     * 获取水站
     *
     * @param stationHandlerChain 链
     * @return 水站名称
     */
    @Override
    public String getStation(StationHandlerChain stationHandlerChain) {
        System.out.println("第四方获取水站成功!!!");

        stationHandlerChain.getStation();
        return "娃哈哈水站第四方3号";
    }
}
