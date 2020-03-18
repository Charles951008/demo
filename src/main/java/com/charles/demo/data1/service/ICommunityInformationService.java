package com.charles.demo.data1.service;

import com.charles.demo.tools.ResultPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wsl
 * @date
 */
@Mapper
public interface ICommunityInformationService {
    /**
     * 111
     * @param areaName
     * @return
     */
    List<Map<String,Object>> getUserList(@Param(value = "areaName") String areaName);
}
