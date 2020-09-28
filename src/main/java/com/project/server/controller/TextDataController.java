package com.project.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.Target;
import com.project.server.entity.TextData;
import com.project.server.repository.TargetRepository;
import com.project.server.repository.TextDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TextDataController {
    @Autowired
    private TargetRepository targetRepository;
    @Autowired
    private TextDataRepository textDataRepository;

    @RequestMapping("/text/upload")
    public void upload(@RequestParam(name = "text") String textStr){
        TextData textData = JSONObject.parseObject(textStr, TextData.class);
        textDataRepository.save(textData);
    }

    @PostMapping("/text/list")
    public String list(@RequestParam(name = "targetId") Integer targetId){
        Target target = targetRepository.findById(targetId).get();
        return JSONArray.toJSONString(textDataRepository.findByTarget(target));
    }
}
