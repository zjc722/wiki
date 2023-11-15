package com.gec.wiki.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.gec.demo.mapper")
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor()
    {
// 创建拦截器对象
        MybatisPlusInterceptor mybatisPlusInterceptor = new
                MybatisPlusInterceptor();
// 添加一个内部的插件 配置 mysql 数据库
        mybatisPlusInterceptor.addInnerInterceptor(new
                PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
