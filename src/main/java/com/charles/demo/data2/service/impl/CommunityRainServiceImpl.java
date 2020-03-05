package com.charles.demo.data2.service.impl;

import com.charles.demo.data2.service.ICommunityRainService;
import com.charles.demo.data2.mapper.CommunityRainMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author wsl
 */
@Service
public class CommunityRainServiceImpl implements ICommunityRainService, Serializable {
    @Autowired
    private CommunityRainMapper communityInformationMapper;

    /**
     * @param areaName
     * @return
     */
    @Override
    public List<Map<String, Object>> getUserList(@Param(value = "areaName")String areaName) {
        List<Map<String,Object>> result=null;
        result=communityInformationMapper.getUserList(areaName);
        return result;
    }

}
