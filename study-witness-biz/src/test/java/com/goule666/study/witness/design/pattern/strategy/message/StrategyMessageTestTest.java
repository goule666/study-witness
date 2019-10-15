package com.goule666.study.witness.design.pattern.strategy.message;

import com.goule666.study.witness.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class StrategyMessageTestTest extends BaseTest {
    @Autowired
    private StrategyMessageTest strategyMessageTest;

    @Test
    public void test() throws Exception {
        //given
        String msg = "clear";
        String msg1 = "replenishment";

        //when
        strategyMessageTest.test(msg);
        strategyMessageTest.test(msg1);

        //then

    }
}