package com.charles.demo.controller;

import com.charles.demo.data1.service.ICommunityInformationService;
import com.charles.demo.data2.service.ICommunityRainService;
import com.charles.demo.tools.ResultPage;
import com.charles.demo.tools.ResultUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wsl
 * @date
 */
@CrossOrigin
@RestController
public class CommunityInformationController {
    /**
     * spring官方目前已经推荐使用构造函数来进行自动注入 可以替换之前的@Autowired方法 因此他会报黄
     */
    final
    ICommunityInformationService communityInformationService;
    final
    ICommunityRainService communityInformationService2;

    public CommunityInformationController(ICommunityInformationService communityInformationService, ICommunityRainService communityInformationService2) {
        this.communityInformationService = communityInformationService;
        this.communityInformationService2 = communityInformationService2;
    }


    /**
     * @Description 测试本地oracle数据库的接口
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
     * 测试本地Mysql数据库的接口
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
