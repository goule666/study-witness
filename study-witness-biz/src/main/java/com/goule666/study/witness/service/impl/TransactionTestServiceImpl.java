package com.goule666.study.witness.service.impl;

import com.goule666.study.witness.entity.GlUser;
import com.goule666.study.witness.service.GlUserService;
import com.goule666.study.witness.service.TransactionTestService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wlnie
 * @date 2018/12/19 14:51
 * @description 转账 事务 ServiceImpl
 **/
@Service
public class TransactionTestServiceImpl implements TransactionTestService {
    @Resource
    private GlUserService glUserService;
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同一个系统转账
     *
     * @param originId 转账人
     * @param money    金额
     * @param targetId 收账人
     * @return true or false
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean sameSystemTransfer(Integer originId, Integer money, Integer targetId) throws Exception {
        GlUser originGlUser = glUserService.selectByPrimaryKey(originId);
        if (originGlUser != null) {
            if (originGlUser.getBalance() >= money) {
                //1. tom 扣钱
                originGlUser.setBalance(originGlUser.getBalance() - money);

                int deductResult = glUserService.updateByPrimaryKeySelective(originGlUser);
                if (deductResult <= 0) {
                    throw new Exception("扣钱发生异常，请检查");
                }

                //2. Jack 加钱
                GlUser targetGlUser = glUserService.selectByPrimaryKey(targetId);
                targetGlUser.setBalance(targetGlUser.getBalance() + money);

                int addResult = glUserService.updateByPrimaryKeySelective(targetGlUser);
                if (addResult <= 0) {
                    throw new Exception("加钱发生异常，请检查");
                }
                return true;
            } else {
                //余额不足
                return false;
            }
        } else {
            //tom 人不存在
            return false;
        }
    }

    /**
     * 转账
     *
     * @param originId 转账人
     * @param money    金额
     * @param targetId 收账人
     * @return true or false
     */
    @Override
    public Boolean differentSystemTransfer(Integer originId, Integer money, Integer targetId) {
        //1. 本系统扣钱
        //2. 发送Half消息到消息队列
        //3. 返回事务状态
        return null;
    }
}
