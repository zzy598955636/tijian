package com.example.tijianapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ServletComponentScan
@EnableAsync
@MapperScan("com.example.tijianapi.db.dao")
public class TijianApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TijianApiApplication.class, args);
    }

}
