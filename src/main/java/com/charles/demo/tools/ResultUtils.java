package com.charles.demo.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsl
 */
public class ResultUtils {
    /**
     *
     * @Title: ofResultPage
     * @Description: 自定义data数据,返回ResultPage
     * @param data             数据
     * @param currentPageLimit 当前页数据条数
     * @param limits           每页数据条数
     * @param currentPage      当前页码数
     * @param count            总数据条数
     * @return
     */
    public static ResultPage ofSuccessResultPage(Object data, Integer currentPageLimit, Integer limits,
                                                 Integer currentPage, Integer count, Integer countItem) {
        return new ResultPage(data, currentPageLimit, limits, currentPage, count, countItem);
    }


    /**
     * @Title: pageSize
     * @Description: 获得分页信息
     * @param currentPage 当前页
     * @param limits      每页条数
     * @param count       总条数
     * @return list[0]:起始位置,list[1]:终止位置,list[2]:页数
     */
    public static List<Integer> pageSize(Integer currentPage, Integer limits, Integer count) {
        List<Integer> list = new ArrayList<Integer>();

        if (currentPage!=null && limits!=null && currentPage > 0 && limits > 0) {
            // 计算页码
            Integer startItem = (currentPage - 1) * limits + 1;
            Integer endItem = currentPage * limits;

            if (count == null) {
                count = 0;
            }

            Integer temp = count / limits;

            if (count % limits > 0 && temp>0) {
                temp += 1;
            }

            temp = temp > 0 ? temp : 1;

            list.add(startItem);
            list.add(endItem);
            list.add(temp);
        }else {
            for (int i = 0; i < 3; i++) {
                list.add(0);
            }
        }
        return list;
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
