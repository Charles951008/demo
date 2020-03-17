package com.charles.demo.configs;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author Charles
 */
@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper createPaeHelper(){
        PageHelper page= new PageHelper();
        return page;
    }
}
