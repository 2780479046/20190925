package com.lanxin.service;

import com.github.pagehelper.PageHelper;
import com.lanxin.bean.Emp;
import com.lanxin.bean.EmpExample;
import com.lanxin.bean.Result;
import com.lanxin.dao.EmpMapper;
import com.lanxin.uilt.GlobalDefaultExceptionHandler;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 彭志聪 on 2019/8/17.
 */
@Service
public class EmpService implements IempService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Result selectemp(EmpExample empExample,Integer curr,Integer page) {
            PageHelper.startPage(curr, page);

            return Result.ok(empMapper.selectByExample(empExample));

    }

    @Override
    public Result selectByid(Integer oid) {
            Emp emp=empMapper.selectByPrimaryKey(oid);

            return  Result.ok(emp);

    }

    @Override
    public Result selectemp1(EmpExample empExample) {
        return Result.ok(empMapper.selectByExample(empExample));
    }

    @Override
    public Result add(Emp emp) {
        return Result.ok(empMapper.insert(emp));
    }

    @Override
    public Result update(Emp emp) {
        return Result.ok(empMapper.updateByPrimaryKey(emp));
    }

    @Override
    public Result delete(Integer oid) {
        return Result.ok(empMapper.deleteByPrimaryKey(oid));
    }
}
