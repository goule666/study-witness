package com.goule666.study.witness.design.pattern.strategy.memberPrice;

import java.math.BigDecimal;

/**
 * @author wlnie
 * @date 2019/9/8 20:58
 * @description 默认原价
 **/
@TotalValidRegion(@ValidRegion(min = 0, max = 5000, order = 90))
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
@TotalValidRegion(@ValidRegion(min = 5000, max = 10000, order = 90))
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
@TotalValidRegion(@ValidRegion(min = 10000, order = 99))
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

/**
 * 满减活动 满1000-200
 */
@OnceValidRegion(@ValidRegion(min = 0, max = 1000, order = 40))
class Activity1 implements CalPrice {

    /**
     * 根据原价计算优惠后的金额
     *
     * @param originalPrice 原价
     * @return 优惠后的金额
     */
    @Override
    public BigDecimal calPrice(BigDecimal originalPrice) {
        return originalPrice.subtract(new BigDecimal(200));
    }
}


/**
 * 满减活动 满2000-400
 */
@OnceValidRegion(@ValidRegion(min = 2000, order = 40))
class Activity2 implements CalPrice {

    /**
     * 根据原价计算优惠后的金额
     *
     * @param originalPrice 原价
     * @return 优惠后的金额
     */
    @Override
    public BigDecimal calPrice(BigDecimal originalPrice) {
        return originalPrice.subtract(new BigDecimal(400));
    }
}

class Activity3 implements CalPrice {

    /**
     * 根据原价计算优惠后的金额
     *
     * @param originalPrice 原价
     * @return 优惠后的金额
     */
    @Override
    public BigDecimal calPrice(BigDecimal originalPrice) {
        return originalPrice.subtract(new BigDecimal(400));
    }
}
