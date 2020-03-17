package com.charles.demo.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wsl
 */
public class ResultUtils {
    /**
     *
     * @Title: ofResultPage
     * @Description: 自定义data数据,返回ResultPage
     * @param data             数据
     * @param limits           每页数据条数
     * @param currentPage      当前页码数
     * @param count            总数据条数
     * @return
     */
    public static ResultPage ofSuccessResultPage(List<Map<String, Object>> data, Integer limits,
                                                 Integer currentPage, Integer count, Integer countItem) {
        return new ResultPage(data, limits, currentPage, count, countItem);
    }



    /**
     *
     * @Title: ofResultPage
     * @Description: 返回结果码为0,data数据为"",分页数据都为0
     * @return
     */
    public static ResultPage ofFailResultPage() {
        return new ResultPage(Result.FAIL, Result.FAIL_MESSAGE, Result.DATA_NULL);
    }
}
