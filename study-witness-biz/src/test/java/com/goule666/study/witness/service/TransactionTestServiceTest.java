package com.goule666.study.witness.service;

import com.goule666.study.witness.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;


public class TransactionTestServiceTest extends BaseTest {

    @Autowired
    private TransactionTestService transactionTestService;

    @Test
    public void sameSystemTransfer() throws Exception {
        //given
        Integer originId = 1;
        Integer money = 0;
        Integer targetId = 2;

        //when
        Boolean flg = transactionTestService.sameSystemTransfer(originId, money, targetId);

        //then
        Assert.isTrue(flg, "结果失败，请检查");
    }

    @Test
    public void transfer() {

    }
}