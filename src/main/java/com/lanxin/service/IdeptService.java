package com.lanxin.service;

import com.lanxin.bean.*;

/**
 * Created by 彭志聪 on 2019/8/17.
 */
public interface IdeptService {

    public Result selectdept(DeptExample deptExample);

    public Result add(Dept dept);

    public Result update(Dept dept);

    public Result delete(Integer oid);

    public Result selectByid(Integer oid);
}
