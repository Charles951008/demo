package com.charles.demo.data2.service.Impl;

import com.charles.demo.data2.service.ICommunityRainService;
import com.charles.demo.data2.mapper.CommunityRainMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public class CommunityRainServiceImpl implements ICommunityRainService, Serializable {
    @Autowired
    private CommunityRainMapper communityInformationMapper;

    @Override
    public List<Map<String, Object>> getUserList(@Param(value = "areaname")String areaname) {
        List<Map<String,Object>> result=null;
        result=communityInformationMapper.getUserList(areaname);
        return result;
    }

}
