package com.github.education.module;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jackwu
 */
@Slf4j
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() throws Exception {
        log.info("123");
        throw new Exception();
    }
}
