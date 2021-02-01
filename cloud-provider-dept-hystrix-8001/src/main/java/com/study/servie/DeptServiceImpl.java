package com.study.servie;

import com.study.dao.DeptDao;
import com.study.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zoe
 * @Description:
 * @Date: 2021/1/31
 */
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptDao deptDao;

    public boolean addDept(Dept dept){
        return deptDao.addDept(dept);
    }

    public Dept queryById(Long id){
        return deptDao.queryById(id);
    }

    public List<Dept> queryAll(){
        return deptDao.queryAll();
    }
}
