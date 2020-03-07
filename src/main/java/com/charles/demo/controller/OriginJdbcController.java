package com.charles.demo.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.charles.demo.data1.pojo.JdbcUtils;
import com.charles.demo.data1.pojo.OriginJdbcObject;
import com.charles.demo.data1.service.IOriginJdbcService;
import oracle.jdbc.OracleConnection;
import org.hamcrest.core.IsNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Charles
 * @Description 借助原生jdbc返回数据并处理 仅作学习基础知识使用
 *
 */
@CrossOrigin
@RestController
public class OriginJdbcController {
    private static final Logger log = LoggerFactory.getLogger(OriginJdbcController.class);
@Autowired
    IOriginJdbcService originJdbcService;
    @RequestMapping(value = "/TestJdbc")
    public List<OriginJdbcObject> OriginJdbcTest(
            @RequestParam(value = "areaName", defaultValue = "", required = false) String areaName,
            @RequestParam(value = "objectId", defaultValue = "", required = false) Integer objectId
    ) {
        List<OriginJdbcObject> result=new LinkedList<>();
        result = originJdbcService.getOriginJdbcData(areaName,objectId);
        return result;
    }
}
