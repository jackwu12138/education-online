package com.github.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 后端的启动类
 *
 * @author jackwu
 */
@SpringBootApplication(scanBasePackages = "com.github.education.module")
public class EducationOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationOnlineApplication.class, args);
    }
}
