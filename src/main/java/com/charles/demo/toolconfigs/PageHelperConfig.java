package com.charles.demo.toolconfigs;

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
    @Primary
    public PageHelper createPaeHelper(){
        PageHelper page= new PageHelper();
        return page;
    }
}
