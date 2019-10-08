package com.goule666.study.witness.design.pattern.chain;

import java.util.List;

/**
 * @author wlnie
 * @date 2019/10/8 23:29
 * @description 获取水站处理链抽象类
 **/
public interface StationHandlerChain {

    /**
     * 添加获取水站处理类
     *
     * @param handler 获取水站处理类
     * @return true or false
     */
    StationHandlerChain addHandler(StationHandler handler);

    /**
     * 获取水站信息
     *
     * @return 水站信息
     */
    List<String> getStation();


}
