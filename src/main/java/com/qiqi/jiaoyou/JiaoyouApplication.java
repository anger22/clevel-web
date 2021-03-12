package com.qiqi.jiaoyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
@SpringBootApplication
@MapperScan("com.qiqi.jiaoyou.mapper")
public class JiaoyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiaoyouApplication.class, args);
    }

}
