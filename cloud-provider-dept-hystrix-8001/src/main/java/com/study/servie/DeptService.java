package com.study.servie;

import com.study.pojo.Dept;

import java.util.List;

/**
 * @Author: zoe
 * @Description:
 * @Date: 2021/1/31
 */
public interface DeptService {

    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
