package com.charles.demo.data1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wsl
 * @date
 */

@Mapper
public interface CommunityInformationMapper {
    /**
     * 获取单页查询结果
     * @param areaName
     * @return
     */
    List<Map<String,Object>> getCommunityInf(@Param(value = "areaName") String areaName);

    /**
     * 获取全部数据条数
     * @param areaName
     * @return
     */
    Integer getCommunityNum(
            @Param(value = "areaName") String areaName);
}
