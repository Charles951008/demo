package com.charles.demo.controller;

import com.charles.demo.tools.OriginJdbcObject;
import com.charles.demo.data1.service.IOriginJdbcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Charles
 * @Description 借助原生jdbc返回数据并处理 仅作学习基础知识使用
 */
@CrossOrigin
@RestController
public class OriginJdbcController {
    private static final Logger log = LoggerFactory.getLogger(OriginJdbcController.class);
    final IOriginJdbcService originJdbcService;

    public OriginJdbcController(IOriginJdbcService originJdbcService) {
        this.originJdbcService = originJdbcService;
    }

    @RequestMapping(value = "/TestJdbc")
    public List<OriginJdbcObject> OriginJdbcTest(
            @RequestParam(value = "areaName", defaultValue = "", required = false) String areaName,
            @RequestParam(value = "objectId", defaultValue = "", required = false) Integer objectId
    ) {
        List<OriginJdbcObject> result;
        result = originJdbcService.getOriginJdbcData(areaName, objectId);
        return result;
    }
}
