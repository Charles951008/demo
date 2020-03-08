package com.charles.demo.controller;

import com.charles.demo.data1.service.ICommunityInformationService;
import com.charles.demo.data2.service.ICommunityRainService;
import com.charles.demo.tools.ResultPage;
import com.charles.demo.tools.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author wsl
 * @date
 */
@CrossOrigin
@RestController
public class CommunityInformationController {
    @Autowired
    ICommunityInformationService communityInformationService;
    @Autowired
    ICommunityRainService communityInformationService2;



    /**
     * 测试本地数据的接口
     * @param areaName
     * @return
     */
    @RequestMapping(value = "/wsl111")
    public ResultPage findCommunity(
            @RequestParam(value = "areaName", defaultValue = "", required = false) String areaName,
            @RequestParam(value = "currentPage",defaultValue = "",required = false) Integer currentPage,
            @RequestParam(value = "limits",defaultValue = "",required = false) Integer limits
    ) {
        Boolean hasPage = true;
        if (limits <= 0 || currentPage <= 0) {

            hasPage = false;
        }

        ResultPage resultPage = ResultUtils.ofFailResultPage();
        // 设置当前页
        resultPage.setCurrentPage(currentPage);
        // 设置每页条数
        resultPage.setLimits(limits);
        resultPage = communityInformationService.getUserList(areaName,resultPage);
        return resultPage;
    }

    /**
     * 测试49数据库的接口
     * @param areaName
     * @return
     */
    @RequestMapping(value = "/wsl222")
    public List<Map<String, Object>> findWaterCollect(
            @RequestParam(value = "areaName", defaultValue = "", required = false) String areaName
    ) {
        List<Map<String, Object>> result = communityInformationService2.getUserList(areaName);
        return result;

    }
}
