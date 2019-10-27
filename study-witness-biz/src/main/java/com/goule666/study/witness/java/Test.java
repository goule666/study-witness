package com.goule666.study.witness.java;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wlnie
 * @date 2019/10/10 11:48
 * @description
 **/
public class Test {

    public Map<String, String> map1 = new HashMap<>(16);

    public Map<String, String> map2 ;

    {
        map1.put("1", "1");
        //如果这里是new HashMap<>(map1)的话 map2就不会随着map1的变化而变化了
        map2 = Collections.unmodifiableMap(map1);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.map1.put("2", "2");
        System.out.println(test);
    }


}
