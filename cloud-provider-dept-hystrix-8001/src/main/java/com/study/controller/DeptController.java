package com.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.pojo.Dept;
import com.study.servie.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: zoe
 * @Description: 提供Restful服务
 * @Date: 2021/1/31
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrix_get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("id=>" + id + "不存在该用户，或者信息无法找到");
        }
        return dept;
    }

    //备选方法
    public Dept hystrix_get(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptno(id).
                setDname("id=>" + id + "没有对应的信息，null--@Hystrix")
                .setDb_source("no database in MySQL");
    }
}
