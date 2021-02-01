package com.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zoe
 * @Description:
 * @Date: 2021/2/1
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myRule(){
        return new MyRandomRule();
    }
}
