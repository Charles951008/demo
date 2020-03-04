package com.charles.demo.data2.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ICommunityRainService {
    List<Map<String,Object>> getUserList(@Param(value = "areaname") String areaname);
}
