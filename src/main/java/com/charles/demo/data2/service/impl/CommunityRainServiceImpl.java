package com.charles.demo.data2.service.impl;

import com.charles.demo.data2.mapper.CommunityRainMapper;
import com.charles.demo.data2.service.ICommunityRainService;
import com.charles.demo.tools.Result;
import com.charles.demo.tools.ResultPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private final CommunityRainMapper communityRainMapper;


    public CommunityRainServiceImpl(CommunityRainMapper communityRainMapper) {
        this.communityRainMapper = communityRainMapper;
    }

    @Resource
    private RedisTemplate<String, List<Map<String, Object>>> redisTemplate;


    /**
     * @param areaName
     * @param currentPage
     * @param limits
     * @return
     */
    @Override
    public ResultPage getUserList(@Param(value = "areaName") String areaName,
                                  @Param(value = "currentPage") Integer currentPage,
                                  @Param(value = "limits") Integer limits
    ) {
        ResultPage result = new ResultPage();
        //查询缓存
        List<Map<String, Object>> communityList = redisTemplate.opsForValue().get("allCommunity" + areaName + "'s tablePage " + currentPage);

        if (null == communityList) {
            //缓存为空，查询一遍数据
            Page page = PageHelper.startPage(currentPage, limits);
            PageHelper.orderBy("STATIONID ASC");
            communityList = communityRainMapper.getUserList(areaName);
            long total = page.getTotal();
            result.setCountItem((int)total);
            redisTemplate.opsForValue().set("allCommunity" + areaName + "'s tablePage " + currentPage, communityList);
        }else{
            int countItem=communityRainMapper.getUserTotal(areaName);
            result.setCountItem(countItem);
        }
        result.setCurrentPage(currentPage);
        result.setLimits(limits);
        result.setCount(result.getCountItem()/limits+1);
        /* 页码传错容错 低于第1页或者高于最高页会返回第一页或者最高页 */
        if(currentPage>result.getCount()){
            result.setCurrentPage(result.getCount());
            result.setMention(Result.PAGE_NUMBER_IS_WRONG);
        }else if(currentPage<=0){
            result.setCurrentPage(1);
            result.setMention(Result.PAGE_NUMBER_IS_WRONG);
        }
        result.setData(communityList);
        if(result.data==null || result.data.isEmpty()){
            result.setMessage(Result.SEARCH_FOR_NO_DATA);
            result.setStatus(Result.SEARCH_NODATA_CODE);
        }
        return result;
    }
}
