package org.example.API;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogAPI {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping("dolog")
    @ResponseBody
    public String log() {
        logger.info("AOP Test!!");
        return "AOP Test Retrun";
    }
}
