package com.goule666.study.witness.design.pattern.chain;

import com.goule666.study.witness.design.pattern.chain.impl.StationFourHandlerImpl;
import com.goule666.study.witness.design.pattern.chain.impl.StationHandlerChainImpl;
import com.goule666.study.witness.design.pattern.chain.impl.StationInnerHandlerImpl;
import com.goule666.study.witness.design.pattern.chain.impl.StationThirdHandlerImpl;

import java.util.List;

/**
 * @author wlnie
 * @date 2019/10/8 23:54
 * @description 责任链模式
 * 定义：为了避免请求的发送者和接受者之间的耦合关系，使多个对象都有机会处理请求。将这些对象连接成一条链，并沿着这条链传递该请求，直到有对象处理他为止
 * 自我理解：对于一个请求，存在多个处理对象都需要有机会处理该请求，所以将这些对象连接成一条链，请求沿着这条链传递下去，直到有对象处理为止
 * 责任链模式分为两种：纯、不纯。
 * 纯：
 * 1. 一个处理者对象只能在两个行为里面选择一个，要不处理，要不传递给下一个处理者对象。不允许处理部分责任之后又传递给下一个处理者对象
 * 2. 在这些处理者对象链中，必须有一个能处理请求
 * 不纯：
 * 1. 允许处理者对象处理请求后在向下传递
 * 2. 允许请求最终未被任何对象处理
 * 纯的模式一般可以采用策略模式替代，实际应用不纯的场景会更常见一些
 *
 * 源码设计到的一些案例：
 * 1. spring security
 * 2. servlet
 *
 * 当前案例场景：
 * 界面需要获取水站列表信息，一共有三种渠道可以获取水站，1：内部，2：第三方，3：第四方
 * 当前案例可以升级为按照优先级获取水站，一旦有一个处理了，则返回。这种需要根据业务场景实际来变动
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
