package com.qudehu;

import cn.xuyanwu.spring.file.storage.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qudehu
 * @date 2023/9/20
 */
@SpringBootApplication
@EnableFileStorage
public class QudehuAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(QudehuAdminApplication.class, args);
    }
}
