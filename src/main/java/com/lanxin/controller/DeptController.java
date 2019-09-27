package com.lanxin.controller;

import com.lanxin.bean.Dept;
import com.lanxin.bean.DeptExample;
import com.lanxin.bean.Emp;
import com.lanxin.bean.Result;
import com.lanxin.service.IdeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 彭志聪 on 2019/8/29.
 */

@RestController
@RequestMapping(value = "dept")
public class DeptController {

    @Autowired
    private IdeptService ideptService;

    //查询所有部门

    @RequestMapping(value = "listdept")
    public Result listdept(){

        DeptExample deptExample = new DeptExample();

        return ideptService.selectdept(deptExample);
    }


    //添加
    @RequestMapping(value = "add")
    public Result add(@RequestBody Dept dept){

        return ideptService.add(dept);

    }
    //修改
    @RequestMapping(value = "update")
    public Result update(@RequestBody Dept dept){

        return ideptService.update(dept);

    }

    //删除

    @RequestMapping(value = "delete")
    public Result delete(Integer oid){

        return ideptService.delete(oid);

    }





}
