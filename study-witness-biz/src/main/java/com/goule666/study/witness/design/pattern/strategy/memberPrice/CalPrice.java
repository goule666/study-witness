package com.goule666.study.witness.design.pattern.strategy.memberPrice;

import java.math.BigDecimal;

/**
 * @author wlnie
 * @date 2019/9/8 20:56
 * @description 计算价格的接口
 **/
public interface CalPrice {
    /**
     * 根据原价计算优惠后的金额
     *
     * @param originalPrice 原价
     * @return 优惠后的金额
     */
    BigDecimal calPrice(BigDecimal originalPrice);
}
