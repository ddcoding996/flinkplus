package com.ddcoding.flinkplus.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.ddcoding.flinkplus.dao.mapper")
@SpringBootApplication(scanBasePackages = {"com.ddcoding.flinkplus"})
public class FlinkplusBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(FlinkplusBootstrap.class, args);
    }
}
