package com.goule666.study.witness.redis;

import com.goule666.study.witness.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.concurrent.*;


public class RedisTestTest extends BaseTest {

    private ThreadPoolExecutor threadsPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 3, Runtime.getRuntime().availableProcessors() * 3, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    @Autowired
    private RedisTest redisTest;

    @Test
    public void test() throws InterruptedException {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            threadsPool.execute(() -> {
                try {
                    redisTest.doSomeThing(uuid, 10000L);
                } catch (RuntimeException e) {
                    System.out.println("任务执行失败！异常原因：" + e.getMessage());
                } finally {
                    countDownLatch.countDown();
                    System.out.println("countDownLatch====>" + countDownLatch.getCount());
                }
            });
        }
        countDownLatch.await();
        //这里多线程总结下execute和submit的区别
        //1. execute，如果子线程有异常，子线程会直接抛出。
        //2. submit，如果子线程有异常，子线程不会直接抛出，会把异常收集起来，在threadsPool.get()的时候通过主线程把错误抛出来。
        //3. 无论是那种方式，直接在子线程里面处理异常是比较妥的方案。
    }


}