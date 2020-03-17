package com.charles.demo.tools;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author wsl
 * @ClassName: Result
 * @Description: 响应结果模型
 */
public class Result implements Serializable {

    /**
     * serialVersionUID: 序列化ID
     */
    private static final long serialVersionUID = -6017430993588164012L;
    /**
     * 结果码
     */
    private String status = SUCCESS;
    /**
     * 消息
     */
    private String message = SUCCESS_MESSAGE;
    /**
     * 数据
     */
    public List<Map<String, Object>> data = null;
    /**
     * 成功返回码
     */
    public final static String SUCCESS = "1";
    /**
     * 失败返回码
     */
    public final static String FAIL = "0";
    public final static String SEARCH_NODATA_CODE = "303";
    /**
     * 成功返回消息
     */
    public final static String SUCCESS_MESSAGE = "成功";
    /**
     * 失败返回消息
     */
    public final static String FAIL_MESSAGE = "失败";

    public final static String SEARCH_FOR_NO_DATA = "查无数据!请检查参数！";
    /**
     * 数据空
     */
    public final static List<Map<String, Object>> DATA_NULL = null;



    public Result() {
        super();
    }
    public Result(String status, String message, List<Map<String, Object>> data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public Result(String status, String message, String data) {
        super();
        this.status = status;
        this.message = message;
        this.data = DATA_NULL;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

}
