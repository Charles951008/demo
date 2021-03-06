package com.charles.demo.tools;

import java.util.List;
import java.util.Map;

/**
 * @author wsl
 * @ClassName	ResultPage
 * @Description	分页结果类
 */
public class ResultPage extends Result {

    /**
     * serialVersionUID: TODO
     */
    private static final long serialVersionUID = 3159620767585997597L;

    /**
     * 每页数据条数
     */
    private Integer limits =NUMBER_ZERO;
    /**
     * 当前页码数
     */
    private Integer currentPage =NUMBER_ZERO;
    /**
     * 总数据页数
     */
    private Integer count =NUMBER_ZERO;

    /**
     * countItem: 总数据条数
     */
    private Integer countItem =NUMBER_ZERO;

    public static final Integer NUMBER_ZERO = 0;

    private String status="200";
    private String message="成功！";
    private String mention="正常！";

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public ResultPage() {
        super();
    }

    public ResultPage(String status, String message, List<Map<String, Object>> data) {
        super(status, message, data);
    }

    public ResultPage( Integer limits, Integer currentPage, Integer count) {
        super();

        this.limits = limits;
        this.currentPage = currentPage;
        this.count = count;
    }

    public ResultPage(List<Map<String, Object>> data, Integer limits, Integer currentPage, Integer count) {
        super(Result.SUCCESS, Result.SUCCESS_MESSAGE, data);

        this.limits = limits;
        this.currentPage = currentPage;
        this.count = count;
    }



    public ResultPage(List<Map<String, Object>> data, Integer limits, Integer currentPage, Integer count, Integer countItem) {
        super(Result.SUCCESS, Result.SUCCESS_MESSAGE,Result.PAGE_NUMBER_IS_WRONG, data);
        this.limits = limits;
        this.currentPage = currentPage;
        this.count = count;
        this.countItem = countItem;
    }



    public Integer getLimits() {
        return limits;
    }

    public void setLimits(Integer limits) {
        this.limits = limits;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountItem() {
        return countItem;
    }

    public void setCountItem(Integer countItem) {
        this.countItem = countItem;
    }

}
