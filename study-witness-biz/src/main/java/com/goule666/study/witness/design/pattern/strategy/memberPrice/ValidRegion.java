package com.goule666.study.witness.design.pattern.strategy.memberPrice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wlnie
 * @date 2019/9/10 23:25
 * @description 有效区间
 **/

/**
 * Annotation type declaration
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRegion {
    int max() default Integer.MAX_VALUE;

    int min() default Integer.MIN_VALUE;

    /**
     * 多个策略 排序
     *
     * @return int
     */
    int order() default 0;

}
