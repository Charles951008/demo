package com.charles.demo.controller;

import com.charles.demo.data1.pojo.UserEntity;
import com.charles.demo.tools.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: springboot
 * @Date: 2020/03/05 12:59
 * @Author: Charles
 * @Description:
 */
@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {
    /**
     *  redis中存储的过期时间60s
     */
    private static int ExpireTime = 60;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("set")
    public boolean redisSet(String key, String value){
        UserEntity userEntity =new UserEntity();
        userEntity.setId(Long.valueOf(1));
        userEntity.setGuid(String.valueOf(1));
        userEntity.setName("zhangsan");
        userEntity.setAge(String.valueOf(20));
        userEntity.setCreateTime(new Date());


        return redisUtil.set(key,value);
    }

    @RequestMapping("get")
    public Object redisGet(String key){
        return redisUtil.get(key);
    }

    @RequestMapping("expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }
}
