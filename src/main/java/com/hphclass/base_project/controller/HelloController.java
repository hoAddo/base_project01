package com.hphclass.base_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
            int j = i;
            System.out.println(j);
        }
        System.out.println("123".equals("123"));
        System.out.println(list);
        return "helloword";
    }
}
