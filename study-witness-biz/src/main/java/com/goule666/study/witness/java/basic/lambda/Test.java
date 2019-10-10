package com.goule666.study.witness.java.basic.lambda;

import com.alibaba.fastjson.JSON;
import com.goule666.study.witness.entity.GlUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>(10);
        list.add("张三");
        list.add("李四");
        list.add("王五");

        Test test = new Test();
        //只是为了尝试自己写一个lambda，实际不会这么写
        test.nameFilter(list, (name -> "李四".equals(name)), (print -> System.out.println(print)));

        //Lambda配合Optional<T>可以使Java对于null的处理变的异常优雅
        GlUser glUser = new GlUser();
        glUser.setName("123");
        Optional<GlUser> glUserOptional = Optional.ofNullable(glUser);

        //1. 第一种
        glUserOptional.ifPresent((x) -> {
            System.out.println(JSON.toJSONString(x));
        });

        //2. 第二种 存在则返回 不存在返回指定的
        glUser = glUserOptional.orElse(new GlUser());

        //3. 第三种
        glUserOptional.orElseGet(() -> {
            GlUser glUser1 = new GlUser();
            glUser1.setBalance(1);
            return glUser1;
        });

        //4. 第四种 多个参数检查
        String name = glUserOptional.map(GlUser::getName).orElseThrow(() -> new Exception("参数不能为空，请检查"));
        System.out.println(name);
    }
}
