package com.project.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.Target;
import com.project.server.entity.ImageData;
import com.project.server.repository.ImageDataRepository;
import com.project.server.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImageDataController {
    @Autowired
    private TargetRepository targetRepository;
    @Autowired
    private ImageDataRepository imageDataRepository;

    @RequestMapping("/image/upload")
    public void upload(@RequestParam(name = "image") String imageStr){
        ImageData imageData = JSONObject.parseObject(imageStr, ImageData.class);
        imageDataRepository.save(imageData);
    }

    @PostMapping("/image/list")
    public String list(@RequestParam(name = "targetId") Integer targetId){
        Target target = targetRepository.findById(targetId).get();
        return JSONArray.toJSONString(imageDataRepository.findByTarget(target));
    }
}
