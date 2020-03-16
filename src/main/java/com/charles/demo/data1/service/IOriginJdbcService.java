package com.charles.demo.data1.service;

import com.charles.demo.tools.OriginJdbcObject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author Charles
 * @date 2020年3月7日12:04:33
 */
public interface IOriginJdbcService {
    /**
     *jdbc原始方法接口
     * @param areaName 区县
     * @param objectId 主键
     * @return List<OriginJdbcObject>
     */
    List<OriginJdbcObject> getOriginJdbcData(@Param(value = "areaName") String areaName,
                                             @Param(value = "objectId") Integer objectId);
}
