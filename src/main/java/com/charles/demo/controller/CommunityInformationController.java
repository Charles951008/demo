package com.charles.demo.controller;

import com.charles.demo.data1.service.ICommunityInformationService;
import com.charles.demo.data2.service.ICommunityRainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 *
 */
@CrossOrigin
@RestController
public class CommunityInformationController {
    @Autowired
    ICommunityInformationService communityInformationService;
    @Autowired
    ICommunityRainService communityInformationService2;

    @RequestMapping(value = "/wsl111")
    public List<Map<String, Object>> findCommunity(
            @RequestParam(value = "areaname", defaultValue = "", required = false) String areaname
    ) {
        List<Map<String, Object>> result = null;
        result = communityInformationService.getUserList(areaname);
        return result;
    }

    @RequestMapping(value = "/wsl222")
    public List<Map<String, Object>> findJishui(
            @RequestParam(value = "areaname", defaultValue = "", required = false) String areaname
    ) {
        List<Map<String, Object>> result = null;
        result = communityInformationService2.getUserList(areaname);
        return result;

    }
}
