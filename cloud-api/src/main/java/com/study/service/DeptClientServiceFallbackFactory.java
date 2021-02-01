package com.study.service;

import com.study.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: zoe
 * @Description:
 * @Date: 2021/2/1
 */
//降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptno(id).
                                setDname("id=>" + id + "没有对应的信息，客户端提供了降级信息，这个服务现在已经 被关闭")
                        .setDb_source("没有数据");
            }

            public List<Dept> queryAll() {
                return null;
            }

            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
