package com.charles.demo.data1.service.Impl;

import com.charles.demo.data1.service.ICommunityInformationService;
import com.charles.demo.data1.mapper.CommunityInformationMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public class CommunityInformationServiceImpl implements ICommunityInformationService, Serializable {
    @Autowired
    private CommunityInformationMapper communityInformationMapper;

    @Override
    public List<Map<String, Object>> getUserList(@Param(value = "areaname")String areaname) {
        List<Map<String,Object>> result=null;
        result=communityInformationMapper.getUserList(areaname);
        return result;
    }

}
