package com.lanxin.service;

import com.github.pagehelper.PageHelper;
import com.lanxin.bean.*;
import com.lanxin.dao.DeptMapper;
import com.lanxin.dao.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 彭志聪 on 2019/8/17.
 */
@Service
public class DeptService implements IdeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Result selectdept(DeptExample deptExample) {

        return Result.ok(deptMapper.selectByExample(deptExample));
    }

    @Override
    public Result add(Dept dept) {
        return Result.ok(deptMapper.insert(dept));
    }

    @Override
    public Result update(Dept dept) {
        return Result.ok(deptMapper.updateByPrimaryKey(dept));
    }

    @Override
    public Result delete(Integer oid) {
        return Result.ok(deptMapper.deleteByPrimaryKey(oid));
    }

    @Override
    public Result selectByid(Integer oid) {
        return Result.ok(deptMapper.selectByPrimaryKey(oid));
    }


}