package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author laowang
 * @date 2018/12/12 9:21 PM
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AppMember {
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class,args);
    }
}
