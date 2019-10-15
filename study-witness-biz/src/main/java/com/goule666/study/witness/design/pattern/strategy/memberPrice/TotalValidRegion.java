package com.goule666.study.witness.design.pattern.strategy.memberPrice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wlnie
 * @date 2019/9/8 21:02
 * @description 总金额策略
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TotalValidRegion {
    ValidRegion value();
}
