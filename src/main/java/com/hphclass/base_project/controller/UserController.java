package com.hphclass.base_project.controller;

import com.hphclass.base_project.domain.JsonData;
import com.hphclass.base_project.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping(value = "user")
    public Object account() {
        return JsonData.buildSuccess("www.hphclass.com");
    }

    @GetMapping(value = "async_task")
    public JsonData asyncTask() throws InterruptedException, ExecutionException {
        long begin = System.currentTimeMillis();
        //asyncTask.task01();
        //asyncTask.task02();
        //asyncTask.task03();
        Future<String> strFuture04 = asyncTask.task04();
        Future<String> strFuture05 = asyncTask.task05();
        Future<String> strFuture06 = asyncTask.task06();
        for (;;){
            if (strFuture04.isDone()&&strFuture05.isDone()&&strFuture06.isDone()){
                break;
            }
        }
        System.out.println("循环后："+strFuture04.get()+","+strFuture05.get()+","+strFuture06.get());
        long end = System.currentTimeMillis();
        long total = end-begin;
        System.out.println("总耗时："+total);
        return JsonData.buildSuccess(total);
    }
}
