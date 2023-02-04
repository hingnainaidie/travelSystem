package com.cqu.travelsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling    //开启调度任务（添加上这个）
@SpringBootApplication
@MapperScan("com.cqu.travelsystem.dao")
public class TravelSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelSystemApplication.class, args);
    }

}
