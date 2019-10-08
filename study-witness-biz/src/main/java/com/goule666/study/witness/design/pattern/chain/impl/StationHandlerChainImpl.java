package com.goule666.study.witness.design.pattern.chain.impl;

import com.goule666.study.witness.design.pattern.chain.StationHandler;
import com.goule666.study.witness.design.pattern.chain.StationHandlerChain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wlnie
 * @date 2019/10/8 23:33
 * @description 获取水站处理链实现类
 **/
public class StationHandlerChainImpl implements StationHandlerChain {
    private int position = 0;

    private List<String> stationList = new ArrayList<>(10);
    /**
     * 处理类集合
     */
    private List<StationHandler> handlerList;

    /**
     * 添加获取水站处理类
     *
     * @param handler 获取水站处理类
     * @return true or false
     */
    @Override
    public StationHandlerChain addHandler(StationHandler handler) {
        if (handlerList == null) {
            handlerList = new ArrayList<>(10);
        }
        handlerList.add(handler);
        return this;
    }

    /**
     * 获取水站信息
     *
     * @return 水站名称
     */
    @Override
    public List<String> getStation() {
        if (position == handlerList.size()) {
            System.out.println("获取水站结束");
            return stationList;
        }
        String station = handlerList.get(position++).getStation(this);
        if (station != null) {
            stationList.add(station);
        }
        return stationList;
    }
}
