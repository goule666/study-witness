package com.goule666.study.witness.config.rocketMq;

import com.goule666.study.witness.service.GlUserService;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

/**
 * @author wlnie
 * @date 2018/12/19 14:34
 * @description 消息队列事务回查实现类
 **/
@RocketMQTransactionListener(txProducerGroup = "transaction-group")
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {

    @Autowired
    private GlUserService glUserService;
    /**
     * 实现执行本地事务的逻辑,并返回本地事务执行状态
     *
     * @param message message
     * @param o       o
     * @return status
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        return null;
    }

    /**
     * 实现本地事务回查的逻辑,并返回本地事务执行状态
     *
     * @param message message
     * @return status
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        return null;
    }
}
