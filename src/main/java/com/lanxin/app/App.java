package com.lanxin.app;

import com.lanxin.filter.MyInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * Created by 彭志聪 on 2019/8/16.
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.lanxin")
@MapperScan(basePackages = "com.lanxin.dao")
@EntityScan(basePackages = "com.lanxin.bean")
@EnableTransactionManagement
public class App {

    public static void main(String[] args){

        SpringApplication.run(App.class,args);
    }

}
