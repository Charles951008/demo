package com.charles.demo.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.charles.demo.data1.pojo.JdbcUtils;
import com.charles.demo.data1.pojo.OriginJdbcObject;
import oracle.jdbc.OracleConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Charles
 * @Description 借助原生jdbc返回数据并处理 仅作学习基础知识使用
 */
@CrossOrigin
@RestController
public class OriginJdbc {
    private static final Logger log= LoggerFactory.getLogger(OriginJdbc.class);
    @RequestMapping(value = "/TestJdbc")
    public List<OriginJdbcObject> doGet(){
        try{
            OracleConnection conn = JdbcUtils.getConn();
            String sql = "select 小区地址,小区名称,OBJECTID,小区类型,街道名称 FROM GIS_COMMUNITY WHERE 区县='嘉定区'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet resultSet = st.executeQuery();

            OriginJdbcObject originJdbcObject = new OriginJdbcObject();

            List<OriginJdbcObject> result=new LinkedList<>();
/**
 * @Description Jdbc原生的数据处理是一次输出一条数据 需要自己动手将数据记录下来
 */
            while(resultSet.next()){
                originJdbcObject.setCommunityAddress(resultSet.getString("小区地址"));
                originJdbcObject.setCommunityName(resultSet.getString("小区名称"));
                originJdbcObject.setOBJECTID(resultSet.getInt("OBJECTID"));
                originJdbcObject.setCommunityType(resultSet.getString("小区类型"));
                originJdbcObject.setStreetName(resultSet.getString("街道名称"));
                result.add(originJdbcObject);
            }
            return result;
        }catch (NullPointerException e){
            e.printStackTrace();
            log.error("sorry！出现空指针!");
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            log.error("sorry!查询语句错了，你也太菜了！");
            return null;
        }

    }
}
