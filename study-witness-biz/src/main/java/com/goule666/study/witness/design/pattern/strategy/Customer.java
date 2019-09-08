package com.goule666.study.witness.design.pattern.strategy;

import java.math.BigDecimal;

/**
 * @author wlnie
 * @date 2019/9/8 20:52
 * @description 策略模式的实现 结合简单工厂模式、单例模式
 * 具体例子描述：顾客购买商品，根据总消费金额分为三个等级，普通、VIP、SUPER_VIP 三种 其中VIP打八折、SUPER_VIP打5折
 * 消费总金额：1. 默认：普通、2. 5000：VIP、3. 10000：SUPER_VIP
 **/
public class Customer {
    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 每一次购买金额
     */
    private BigDecimal amount;

    private CalPrice calPrice;

    {
        totalAmount = new BigDecimal(0);

    }

    public void buy(BigDecimal amount) {
        this.amount = amount;
        this.totalAmount = totalAmount.add(amount);
        calPrice = CreateCalPriceFactory.getInstance().getCalPrice(this);
    }

    public BigDecimal calPrice() {
        return calPrice.calPrice(amount);
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
