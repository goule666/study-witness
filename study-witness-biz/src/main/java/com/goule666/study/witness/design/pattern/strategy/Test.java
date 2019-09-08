package com.goule666.study.witness.design.pattern.strategy;

import java.math.BigDecimal;

/**
 * @author wlnie
 * @date 2019/9/8 21:39
 * @description 测试类
 **/
public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy(new BigDecimal(2000));
        System.out.println("第一次购买，原价是：2000，优惠后金额是："
                + customer.calPrice().intValue() + "当前购买总额：" + customer.getTotalAmount());
        customer.buy(new BigDecimal(6000));
        System.out.println("第二次购买，原价是：6000，优惠后金额是："
                + customer.calPrice().intValue() + "当前购买总额：" + customer.getTotalAmount());
        customer.buy(new BigDecimal(4000));
        System.out.println("第三次购买，原价是：4000，优惠后金额是："
                + customer.calPrice().intValue() + "当前购买总额：" + customer.getTotalAmount());
    }
}
