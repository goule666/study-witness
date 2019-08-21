package com.goule666.study.witness.service;

/**
 * @author wlnie
 * @date 2018/12/19 14:51
 * @description 转账 事务 Service
 **/
public interface TransactionTestService {
    /**
     * 同一个系统转账
     *
     * @param originId 转账人
     * @param money    金额
     * @param targetId 收账人
     * @return true or false
     * @throws Exception
     */
    Boolean sameSystemTransfer(Integer originId, Integer money, Integer targetId) throws Exception;

    /**
     * 不同系统转账
     *
     * @param originId 转账人
     * @param money    金额
     * @param targetId 收账人
     * @return true or false
     */
    Boolean differentSystemTransfer(Integer originId, Integer money, Integer targetId);
}
