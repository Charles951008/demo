package com.charles.demo.data1.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ICommunityInformationService {
    List<Map<String,Object>> getUserList(@Param(value = "areaname") String areaname);
}
