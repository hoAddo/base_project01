package com.hphclass.base_project;

import com.hphclass.base_project.domain.User;
import com.hphclass.base_project.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BaseProjectApplication.class})
public class JsonTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testOne(){
        User user = new User();
        user.setAge(18);
        user.setCreateTime(new Date());
        user.setPhone("1008611");
        user.setPwd("123456");
        String str = JsonUtils.obj2String(user);
        System.out.println(str);
        stringRedisTemplate.opsForValue().set("str:01:02",str);
    }
}
