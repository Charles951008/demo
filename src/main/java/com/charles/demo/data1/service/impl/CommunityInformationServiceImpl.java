package com.charles.demo.data1.service.impl;

import com.charles.demo.data1.mapper.CommunityInformationMapper;
import com.charles.demo.data1.service.ICommunityInformationService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author wsl
 * @date 2020年3月7日15:35:03
 */

@Service
public class CommunityInformationServiceImpl implements ICommunityInformationService, Serializable {
    /**
     * spring官方目前已经推荐使用构造函数来进行自动注入 可以替换之前的@Autowired方法 因此@Autowired会报黄
     */
    private final CommunityInformationMapper communityInformationMapper;

    public CommunityInformationServiceImpl(CommunityInformationMapper communityInformationMapper) {
        this.communityInformationMapper = communityInformationMapper;
    }

    /**
     * 社区信息分页写法
     * @param areaName
     * @return ResultPage
     */
    @Override
    public List<Map<String,Object>> getUserList(String areaName) {
        List<Map<String, Object>> result = communityInformationMapper.getCommunityInf(areaName);
        return result;
    }

}
