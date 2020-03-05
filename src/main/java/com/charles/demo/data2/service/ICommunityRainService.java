package com.charles.demo.data2.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wsl
 */
@Mapper
public interface ICommunityRainService {
    /**
     *获取社区积水详情信息
     * @param areaName
     * @return
     */
    List<Map<String,Object>> getUserList(@Param(value = "areaName") String areaName);
}
