package com.goule666.study.witness.design.pattern.strategy;

import java.math.BigDecimal;

/**
 * @author wlnie
 * @date 2019/9/8 20:52
 * @description 策略模式的实现 结合简单工厂模式、单例模式
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
