package com.charles.demo.controller;

import com.charles.demo.data1.service.ICommunityInformationService;
import com.charles.demo.data2.service.ICommunityRainService;
import com.charles.demo.tools.Result;
import com.charles.demo.tools.ResultPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
     * @param areaName
     * @return
     * @Description 测试本地oracle数据库的接口
     */
    @RequestMapping(value = "/wsl111")
    public ResultPage findCommunity(
            @RequestParam(value = "areaName", defaultValue = "", required = false) String areaName,
            @RequestParam(value = "currentPage", defaultValue = "", required = false) Integer currentPage,
            @RequestParam(value = "limits", defaultValue = "", required = false) Integer limits
    ) {

        Page page = PageHelper.startPage(currentPage, limits);
        PageHelper.orderBy("OBJECTID ASC");
        List<Map<String, Object>> resultPage = communityInformationService.getUserList(areaName);

        long total = page.getTotal();
        ResultPage result = new ResultPage();
        result.setData(resultPage);
        // 设置当前页
        result.setCurrentPage(currentPage);
        // 设置每页条数
        result.setLimits(limits);

        result.setCountItem((int) total);
        result.setCount(result.getCountItem()/limits+1);
        if(result.data==null || result.data.isEmpty()){
            result.setMessage(Result.SEARCH_FOR_NO_DATA);
            result.setStatus(Result.SEARCH_NODATA_CODE);
        }
        return result;
    }

    /**
     * 测试本地Mysql数据库的接口
     *
     * @param areaName
     * @return
     */
    @RequestMapping(value = "/wsl222")
    public ResultPage findWaterCollect(
            @RequestParam(value = "areaName", defaultValue = "", required = false) String areaName,
            @RequestParam(value = "currentPage", defaultValue = "", required = false) Integer currentPage,
            @RequestParam(value = "limits", defaultValue = "", required = false) Integer limits
    ) {
        ResultPage resultPage = communityInformationService2.getUserList(areaName,currentPage,limits);
        return resultPage;
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello!!!!!  Beauty!!!!!";
    }
}
