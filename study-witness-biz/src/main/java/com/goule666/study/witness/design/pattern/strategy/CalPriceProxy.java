package com.goule666.study.witness.design.pattern.strategy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author wlnie
 * @date 2019/9/10 23:43
 * @description
 **/
public class CalPriceProxy implements InvocationHandler {
    private SortedMap<Integer, Class<? extends CalPrice>> sortedMap = new TreeMap<>();

    private CalPriceProxy(SortedMap<Integer, Class<? extends CalPrice>> sortedMap) {
        super();
        this.sortedMap = sortedMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("calPrice")) {
            BigDecimal amount = new BigDecimal(0);
            for (Class<? extends CalPrice> clazz : sortedMap.values()) {
                if (amount.intValue() == 0) {
                    amount = (BigDecimal) method.invoke(clazz.newInstance(), args);
                } else {
                    amount = (BigDecimal) method.invoke(clazz.newInstance(), amount);
                }
            }
            return amount;
        }
        return null;
    }

    public static CalPrice getProxy(SortedMap<Integer, Class<? extends CalPrice>> clazzMap) {
        return (CalPrice) Proxy.newProxyInstance(CalPriceProxy.class.getClassLoader(), new Class<?>[]{CalPrice.class}, new CalPriceProxy(clazzMap));
    }
}
