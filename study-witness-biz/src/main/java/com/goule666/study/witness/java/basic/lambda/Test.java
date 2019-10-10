package com.goule666.study.witness.java.basic.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wlnie
 * @date 2019/10/10 14:40
 * @description lambda 浅浅的了解下
 **/
public class Test {
    public List<String> nameFilter(List<String> list, NameFilter nameFilter, PrintName printName) {
        return list.stream().peek(x -> {
            if (nameFilter.filter(x)) {
                printName.execute(x);
            }
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("张三");
        list.add("李四");
        list.add("王五");

        Test test = new Test();
        //只是为了尝试自己写一个lambda，实际不会这么写
        test.nameFilter(list, (name -> "李四".equals(name)), (print -> System.out.println(print)));

    }
}
