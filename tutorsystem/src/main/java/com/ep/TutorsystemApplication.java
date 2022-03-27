package com.ep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 引导类，springboot的项目入口
 * */
@SpringBootApplication
public class TutorsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorsystemApplication.class, args);
    }

}
