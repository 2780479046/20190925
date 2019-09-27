package com.lanxin.service;

import com.github.pagehelper.PageHelper;
import com.lanxin.bean.Emp;
import com.lanxin.bean.EmpExample;
import com.lanxin.bean.Result;
import com.lanxin.dao.EmpMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 彭志聪 on 2019/8/17.
 */
public interface IempService {



    public Result selectemp(EmpExample empExample,Integer curr,Integer page);

    public Result selectemp1(EmpExample empExample);

    public Result add(Emp emp);

    public Result update(Emp emp);

    public Result delete(Integer oid);

    public Result selectByid(Integer oid);
}
