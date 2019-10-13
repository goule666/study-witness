package com.goule666.study.witness.design.pattern.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wlnie
 * @date 2019/10/13 16:48
 * @description 适配器模式 测试
 **/
public class Test {

    private List<VoltHandlerAdapter> voltHandlerAdapterList = new ArrayList<>(2);

    private Map<String, VoltHandler> voltHandlerMap = new HashMap<>(16);

    {
        //这里初始化适配器和处理器，由于本文重点是表示适配器模式，所以粗略的这样写，如果在实际项目中，应当从spring容器中去获取。
        //得到日本和中国的电压适配器
        VoltHandlerAdapter chinaVoltHandlerAdapter = new ChinaVoltHandlerAdapter();
        VoltHandlerAdapter japanVoltHandlerAdapter = new JapanVoltHandlerAdapter();
        voltHandlerAdapterList.add(chinaVoltHandlerAdapter);
        voltHandlerAdapterList.add(japanVoltHandlerAdapter);

        //得到中国和日本的电压处理器
        voltHandlerMap.put("china", new ChinaVoltHandler() {
            @Override
            public Integer convert(Integer volt) {
                System.out.println("输入电压：" + volt);
                return 220;
            }
        });
        voltHandlerMap.put("japan", new JapanVoltHandler() {
            @Override
            public Integer convert(Integer volt) {
                System.out.println("输入电压：" + volt);
                return 110;
            }
        });
    }

    private void handle(String country, Integer volt) {
        VoltHandler voltHandler = voltHandlerMap.get(country);
        for (VoltHandlerAdapter ha : voltHandlerAdapterList) {
            if (ha.supports(voltHandler)) {
                System.out.println(country + "输出电压：" + ha.handler(volt, voltHandler));
                break;
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.handle("china", 11111);
        test.handle("japan", 123);
    }
}
