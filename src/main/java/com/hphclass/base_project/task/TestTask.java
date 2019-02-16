package com.hphclass.base_project.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestTask {

    //@Scheduled(fixedRate = 2000)
    //@Scheduled(fixedRateString = "2000")
    //@Scheduled(fixedDelayString = "2000")
    //@Scheduled(fixedDelay = 2000)
    public void sum() throws InterruptedException {

        Thread.sleep(4000);
        System.out.println("结束 当前时间："+new Date());
    }

    //@Scheduled(cron = "*/1 * * * * *")
    public void sum02(){
        System.out.println("cron 每秒 当前时间："+new Date());
    }
}
