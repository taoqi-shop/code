package com.taoqi.user.test;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @作者：刘时明
 * @时间：2019/4/12-10:21
 * @作用：
 */
public class RedisSonLockTest
{
    public static int fixNum = 5;

    public static void main(String[] args) throws Exception
    {
        // CountDownLatch是一个同步工具类
        CountDownLatch latch = new CountDownLatch(fixNum);

        RedissonClient redisSon = Redisson.create();

        ExecutorService exec = Executors.newFixedThreadPool(fixNum);

        for (int i = 0; i < fixNum; i++)
        {
            exec.submit(new TestLock("client-" + i, redisSon, latch));
        }
        exec.shutdown();
        latch.await();
        System.out.println("所有任务执行完毕");
    }

    static class TestLock implements Runnable
    {
        private String name;
        RedissonClient redisSon;
        private CountDownLatch latch;

        public TestLock(String name, RedissonClient redisSon, CountDownLatch latch)
        {
            this.name = name;
            this.redisSon = redisSon;
            this.latch = latch;
        }

        @Override
        public void run()
        {
            // 定义锁
            RLock lock = redisSon.getLock("TestLock");
            try
            {
                System.out.println("---" + this.name + "---等待获取锁");
                if(lock.tryLock(300,30, TimeUnit.MILLISECONDS))
                {
                    try
                    {
                        System.out.println("---" + this.name + "---获得锁---");
                        Thread.sleep(2*100);
                        System.out.println("---" + this.name + "---业务处理完毕---");
                    }finally
                    {
                        lock.unlock();
                        System.out.println("---" + this.name + "---释放锁---");
                        latch.countDown();
                    }
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
