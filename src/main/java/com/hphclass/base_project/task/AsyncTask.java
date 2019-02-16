package com.hphclass.base_project.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class AsyncTask {

    public void task01() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(6000L);
        long end = System.currentTimeMillis();
        System.out.println("任务01耗时："+(end-begin));
    }

    public void task02() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(5000L);
        long end = System.currentTimeMillis();
        System.out.println("任务02耗时："+(end-begin));
    }

    public void task03() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(4000L);
        long end = System.currentTimeMillis();
        System.out.println("任务03耗时："+(end-begin));
    }

    //获取异步结果

    public Future<String> task04() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(6000L);
        long end = System.currentTimeMillis();
        long time04 = end-begin;
        return new AsyncResult<String>("任务04耗时："+time04);
    }

    public Future<String> task05() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(5000L);
        long end = System.currentTimeMillis();
        long time05 = end-begin;
        return new AsyncResult<String>("任务05耗时："+time05);
    }

    public Future<String> task06() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(4000L);
        long end = System.currentTimeMillis();
        long time06 = end-begin;
        return new AsyncResult<String>("任务06耗时："+time06);
    }
}
