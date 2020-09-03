package com.i;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.i.mapper")
public class InsertStart {
    public static void main(String[] args) {
        SpringApplication.run(InsertStart.class, args);
    }
}
