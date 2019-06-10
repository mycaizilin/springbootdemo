package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demo")
//@MapperScan("com.example.demo.repository.dao")
//@EnableDubboConfiguration
//@ImportResource(value = {"classpath:provider.xml"})
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
