package com.goule666.study.witness.design.pattern.strategy;

import java.math.BigDecimal;

/**
 * @author wlnie
 * @date 2019/9/8 21:39
 * @description 策略模式
 * 定义：策略模式定义了一系列的算法，并将每个算法封装起来，而且使它们还可以相互替换。策略模式让算法独立于使用它的客户而独立变化。
 * 自我理解：一个抽象接口定义具体行为，N个算法类实现这个接口，客户端依赖抽象接口的行为，不依赖具体的算法
 *
 * 当前案例场景：
 * 顾客购买商品，分为以下两种活动：
 * 1. 根据总消费金额分为三个等级，普通、VIP、SUPER_VIP 三种 其中VIP打八折、SUPER_VIP打5折
 * 2. 满减活动
 * 其中满减活动优先级大于会员等级活动。
 * 本例子采用：策略模式，单例模式，简单工厂模式，代理模式
 *
 **/
public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy(new BigDecimal(900));
        System.out.println("第一次购买，原价是：900，优惠后金额是："
                + customer.calPrice().intValue() + "当前购买总额：" + customer.getTotalAmount());
        customer.buy(new BigDecimal(6000));
        System.out.println("第二次购买，原价是：6000，优惠后金额是："
                + customer.calPrice().intValue() + "当前购买总额：" + customer.getTotalAmount());
        customer.buy(new BigDecimal(4000));
        System.out.println("第三次购买，原价是：4000，优惠后金额是："
                + customer.calPrice().intValue() + "当前购买总额：" + customer.getTotalAmount());
    }
}
