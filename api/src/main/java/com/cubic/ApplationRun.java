package com.cubic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
@MapperScan(basePackages = "com.cubic.dao")
public class ApplationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplationRun.class, args);
    }

}
