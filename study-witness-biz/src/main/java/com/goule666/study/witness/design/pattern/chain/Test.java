package com.goule666.study.witness.design.pattern.chain;

import com.goule666.study.witness.design.pattern.chain.impl.StationFourHandlerImpl;
import com.goule666.study.witness.design.pattern.chain.impl.StationHandlerChainImpl;
import com.goule666.study.witness.design.pattern.chain.impl.StationInnerHandlerImpl;
import com.goule666.study.witness.design.pattern.chain.impl.StationThirdHandlerImpl;

import java.util.List;

/**
 * @author wlnie
 * @date 2019/10/8 23:54
 * @description 责任链模式 案例场景：获取水站信息，一共有两种渠道可以获取，1：内部，2：第三方
 **/
public class Test {
    public static void main(String[] args) {
        StationHandler stationInnerHandler = new StationInnerHandlerImpl();
        StationHandler stationThirdHandler = new StationThirdHandlerImpl();
        StationHandler stationFourHandler = new StationFourHandlerImpl();


        StationHandlerChain chain = new StationHandlerChainImpl();
        List<String> stationList = chain
                .addHandler(stationInnerHandler)
                .addHandler(stationThirdHandler)
                .addHandler(stationFourHandler)
                .getStation();
        System.out.println(stationList);
    }
}
