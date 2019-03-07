package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@ServletComponentScan // 注意要加上@ServletComponentScan注解，否则Servlet无法生效
public class SpringbootJpaDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaDruidApplication.class, args);
    }
}
