package com.github.education.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 后端的启动类
 *
 * @author jackwu
 */
@SuppressWarnings("SpringComponentScan")
@SpringBootApplication(scanBasePackages = "${education.base.base-package}")
public class EducationOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationOnlineApplication.class, args);
    }
}
