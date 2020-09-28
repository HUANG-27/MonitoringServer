package com.project.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.UAVData;
import com.project.server.repository.UAVDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UAVDataController {
    @Autowired
    private UAVDataRepository uavDataRepository;

    @RequestMapping("/uavdata/upload")
    public void upload(@RequestParam(name = "uavData") String uavDataStr){
        UAVData uavData = JSONObject.parseObject(uavDataStr, UAVData.class);
        uavDataRepository.save(uavData);
    }

    @RequestMapping("/uavdata/list")
    public String list(){
        List<UAVData> uavDataList = uavDataRepository.findAll();
        return JSONArray.toJSONString(uavDataList);
    }
}
