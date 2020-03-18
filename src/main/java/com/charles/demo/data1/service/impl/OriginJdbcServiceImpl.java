package com.charles.demo.data1.service.impl;

import com.charles.demo.controller.OriginJdbcController;
import com.charles.demo.data1.service.IOriginJdbcService;
import com.charles.demo.tools.JdbcUtils;
import com.charles.demo.tools.OriginJdbcObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Charles
 * @date 2020年3月7日14:32:13
 */
@Service
public class OriginJdbcServiceImpl implements IOriginJdbcService {
    private static final Logger log = LoggerFactory.getLogger(OriginJdbcController.class);

    @Override
    public List<OriginJdbcObject> getOriginJdbcData(String areaName, Integer objectId) {
        try {
            /*
              以下是jdbc原生使用方法 明显觉得十分麻烦 况且这还是我在配置了jdbcUtil的情况下
             */
            String sql = "select t.小区地址,t.小区名称,t.OBJECTID,t.小区类型,t.街道名称 FROM gis_community t WHERE 1=1 ";
            if (!areaName.equals("")) {
                sql += "AND t.区县='" + areaName + "'";
                log.info("包含" + areaName + "地区的小区信息");
            }
            if (objectId != null) {
                sql += "AND t.OBJECTID=" + objectId;
                log.info("选择传入主键获取单条记录查询，供撒点定位等功能使用！");
            }
            Connection conn = JdbcUtils.getConn();

            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet resultSet = st.executeQuery();

            List<OriginJdbcObject> result = new LinkedList<>();
            /*
              @Description Jdbc原生的数据处理是一次输出一条数据 需要自己动手将数据记录下来
             */
            while (resultSet.next()) {
                OriginJdbcObject originJdbcObject = new OriginJdbcObject();
                originJdbcObject.setCommunityAddress(resultSet.getString("小区地址"));
                originJdbcObject.setCommunityName(resultSet.getString("小区名称"));
                originJdbcObject.setOBJECTID(resultSet.getInt("OBJECTID"));
                originJdbcObject.setCommunityType(resultSet.getString("小区类型"));
                originJdbcObject.setStreetName(resultSet.getString("街道名称"));
                result.add(originJdbcObject);
            }
            st.close();
            conn.close();
            return result;
        } catch (NullPointerException e) {
            e.printStackTrace();
            log.error("sorry！出现空指针!");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("sorry!查询语句错了，你也太菜了！");
            return null;
        }
    }
}
