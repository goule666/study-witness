package com.goule666.study.witness.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Service;


/**
 * @author wlnie
 * @date 2019/2/25 13:20
 * @description
 **/
@Service
public class RedisTest {
    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取锁
     *
     * @param key        key
     * @param expireTime 过期时间
     * @return 成功 失败
     */
    private Boolean lock(String key, Long expireTime) {
        Long start = System.currentTimeMillis();
        return (Boolean) redisTemplate.execute((RedisCallback) conn -> {
            while (!conn.set(key.getBytes(), key.getBytes(), Expiration.milliseconds(expireTime), RedisStringCommands.SetOption.SET_IF_ABSENT)) {
                //1. 没有得到锁就一直阻塞
                //1.1 如果一直阻塞，超时需要抛出异常
                if ((System.currentTimeMillis() - start) > expireTime) {
                    logger.error("线程：" + Thread.currentThread().getName() + " 获取锁超时.");
                    throw new RuntimeException("线程：" + Thread.currentThread().getName() + " 获取锁超时.");
                }
                //1.2 休息100ms之后接着抢锁
                logger.info("线程：" + Thread.currentThread().getName() + " 休息 100 ms");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2. 得到锁了就直接返回true
            logger.info("线程：" + Thread.currentThread().getName() + " 得到锁.");
            return true;
        });
    }

    private void unlock(String key) {
        redisTemplate.delete(key);
    }

    public void doSomeThing(String key, Long expireTime) {
        try {
            //1. 获取锁
            if (lock(key, expireTime)) {
                //2. 获取到锁之后作事情 模拟业务场景，休息200ms
                Thread.sleep(280);
                for (int i = 0; i < 10; i++) {
                    logger.info("线程：" + Thread.currentThread().getName() + " 正在干活，输出" + i);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //3. 释放锁
            unlock(key);
        }
    }


}
