package com.charles.demo.data1.service;

import com.charles.demo.tools.ResultPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wsl
 * @date
 */
@Mapper
public interface ICommunityInformationService {
    /**
     * 111
     * @param areaName
     * @param query
     * @return
     */
    ResultPage getUserList(@Param(value = "areaName") String areaName,
                           @Param(value = "query") ResultPage query);
}
