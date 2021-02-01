package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zoe
 * @Description:
 * @Date: 2021/1/31
 */
@SpringBootApplication
@EnableEurekaClient//在服务启动后自动注册到Eureka中
@EnableDiscoveryClient//服务发现
public class DeptProvider_8002 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8002.class,args);
    }
}
