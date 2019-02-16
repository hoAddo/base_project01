package com.hphclass.base_project.controller;

import com.hphclass.base_project.domain.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/logback")
public class LogbackController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "log")
    public Object testLog(){
        logger.debug("this is debug level");//不输出，因为日志级别低于<root level="INFO">
        logger.info("this is info level");
        logger.warn("this is warn level");
        logger.error("this is error level");
        return JsonData.buildSuccess();
    }

}
