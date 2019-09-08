package com.goule666.study.witness.design.pattern.strategy;

import java.math.BigDecimal;

/**
 * @author wlnie
 * @date 2019/9/8 20:58
 * @description 默认原价
 **/
@TotalValidRegion(min = 0, max = 5000)
public class CommonCalPriceImpl implements CalPrice {
    /**
     * 根据原价计算优惠后的金额
     *
     * @param originalPrice 原价
     * @return 优惠后的金额
     */
    @Override
    public BigDecimal calPrice(BigDecimal originalPrice) {
        return originalPrice;
    }
}

/**
 * VIP价格
 */
@TotalValidRegion(min = 5000, max = 10000)
class VipCalPriceImpl implements CalPrice {

    /**
     * 根据原价计算优惠后的金额
     *
     * @param originalPrice 原价
     * @return 优惠后的金额
     */
    @Override
    public BigDecimal calPrice(BigDecimal originalPrice) {
        return originalPrice.multiply(new BigDecimal(0.8));
    }
}

/**
 * 超级VIP价格
 */
@TotalValidRegion(min = 10000)
class SuperVipCalPriceImpl implements CalPrice {

    /**
     * 根据原价计算优惠后的金额
     *
     * @param originalPrice 原价
     * @return 优惠后的金额
     */
    @Override
    public BigDecimal calPrice(BigDecimal originalPrice) {
        return originalPrice.multiply(new BigDecimal(0.5));
    }
}
