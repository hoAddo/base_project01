package com.hphclass.base_project.controller;

import com.hphclass.base_project.domain.JsonData;
import com.hphclass.base_project.domain.User;
import com.hphclass.base_project.utils.JsonUtils;
import com.hphclass.base_project.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisTestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisClient redisClient;

    @GetMapping(value = "/add")
    public Object add(){
        //stringRedisTemplate.opsForValue().set("name01","hphclass");
        boolean flag = redisClient.set("str:01:03", "hphclass03");
        if (flag)
            return JsonData.buildSuccess();
        else 
            return JsonData.buildError("失败");
    }

    @GetMapping(value = "/get")
    public Object get(){
        //String value = stringRedisTemplate.opsForValue().get("name01");
        String value = redisClient.get("str:01:03");
        return JsonData.buildSuccess(value);
    }

    @GetMapping(value = "save_user")
    public Object saveUser(){
        User user = new User(1, "123456", "10086", new Date());
        String userStr = JsonUtils.obj2String(user);
        boolean flag = redisClient.set("base:user:1", userStr);
        return JsonData.buildSuccess(flag);
    }

    @GetMapping(value = "find_user")
    public Object findUser(){
        String userStr = redisClient.get("base:user:1");
        User user = JsonUtils.string2Obj(userStr, User.class);
        return JsonData.buildSuccess(user);
    }

}
