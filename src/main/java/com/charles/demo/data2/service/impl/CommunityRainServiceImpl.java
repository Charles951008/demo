package com.charles.demo.data2.service.impl;

import com.charles.demo.data2.mapper.CommunityRainMapper;
import com.charles.demo.data2.service.ICommunityRainService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author wsl
 */
@Service
public class CommunityRainServiceImpl implements ICommunityRainService, Serializable {
    /**
     * spring官方目前已经推荐使用构造函数来进行自动注入 可以替换之前的@Autowired方法 因此@Autowired会报黄
     */
    private final CommunityRainMapper communityInformationMapper;

    public CommunityRainServiceImpl(CommunityRainMapper communityInformationMapper) {
        this.communityInformationMapper = communityInformationMapper;
    }

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
