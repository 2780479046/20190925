package com.lanxin.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 彭志聪 on 2019/8/19.
 */

@Configuration
public class MywebAppConfigurer extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyInterceptor());
    }
}
