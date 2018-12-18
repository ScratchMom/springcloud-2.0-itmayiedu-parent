package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author laowang
 * @date 2018/12/14 11:02 AM
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class AppOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class,args);
    }
}
