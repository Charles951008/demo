package com.charles.demo.data2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommunityRainMapper {
    List<Map<String,Object>> getUserList(@Param(value = "areaname") String areaname);
}
