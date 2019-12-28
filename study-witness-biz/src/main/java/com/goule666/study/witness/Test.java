package com.goule666.study.witness;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wlnie
 * @date 2019/10/15 13:37
 * @description
 **/
public class Test {

    private List<Integer> list = new ArrayList<>();

    private void test() {
        for (int i = 0; i < 100000000; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }
}
