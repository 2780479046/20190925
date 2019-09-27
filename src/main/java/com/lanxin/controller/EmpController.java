package com.lanxin.controller;


import com.lanxin.bean.DeptExample;
import com.lanxin.bean.Emp;
import com.lanxin.bean.EmpExample;
import com.lanxin.bean.Result;
import com.lanxin.service.IdeptService;
import com.lanxin.service.IempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 彭志聪 on 2019/8/17.
 */

@RestController
@RequestMapping(value = "emp")
public class EmpController {

    @Autowired
    private IempService iempService;

    @Autowired
    private IdeptService ideptService;

    @RequestMapping(value = "emplist")
    public Result listemp(Integer curr,Integer page){

        EmpExample empExample = new EmpExample();

        return iempService.selectemp(empExample,curr,page);
    }


    @RequestMapping(value = "selectemp")
    public Result selectByidemp(Integer oid){

        return iempService.selectByid(oid);
    }

    @RequestMapping(value = "login")
    public Result login(@RequestBody Emp emp){

        System.out.println(emp.getEmpname()+"================="+emp.getEage());

        if(emp.getEmpname().equals("1")&&emp.getEage()==32){

            System.out.println("登录成功");

            return Result.ok("200");
        }else{

            System.out.println("登录失败");

            return Result.on();

        }

    }

    //查询所有员工

    @RequestMapping(value = "selemp")
    public Result selectemp(){

        EmpExample empExample = new EmpExample();

        return iempService.selectemp1(empExample);
    }


    //查询所有部门

    @RequestMapping(value = "listdept")
    public Result listdept(){

        DeptExample deptExample = new DeptExample();

        return ideptService.selectdept(deptExample);
    }

    //添加
    @RequestMapping(value = "add")
    public Result add(@RequestBody Emp emp){

        return iempService.add(emp);

    }
//修改
    @RequestMapping(value = "update")
    public Result update(@RequestBody Emp emp){

        return iempService.update(emp);

    }

    //删除

    @RequestMapping(value = "delete")
    public Result delete(Integer oid){

        return iempService.delete(oid);

    }



}
