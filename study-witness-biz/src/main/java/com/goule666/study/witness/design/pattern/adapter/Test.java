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

    private Map<String, Object> voltHandlerMap = new HashMap<>(16);

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
            public Integer japanConvert(Integer volt) {
                System.out.println("输入电压：" + volt);
                return 110;
            }
        });
    }

    private void handle(String country, Integer volt) {
        Object voltHandler = voltHandlerMap.get(country);
        for (VoltHandlerAdapter ha : voltHandlerAdapterList) {
            //策略类模式，这里表示选择某一个策略
            if (ha.supports(voltHandler)) {
                //适配器模式 对象适配器
                //这里故意把handlerAdapter的两个实现类实现的不一样，用来说明，这里采用适配器模式，是为了兼容已有的接口
                //假设ChinaVoltHandler是已有的接口，JapanVoltHandler是新增的接口
                //target：VoltHandlerAdapter
                //source：ChinaVoltHandler、JapanVoltHandler
                //adapter：ChinaVoltHandler、JapanVoltHandlerAdapter
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
