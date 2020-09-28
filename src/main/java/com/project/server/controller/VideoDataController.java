package com.project.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.Target;
import com.project.server.entity.VideoData;
import com.project.server.repository.TargetRepository;
import com.project.server.repository.VideoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoDataController {
    @Autowired
    private TargetRepository targetRepository;
    @Autowired
    private VideoDataRepository videoDataRepository;

    @RequestMapping("/video/upload")
    public void upload(@RequestParam(name = "video") String videoStr){
        VideoData videoData = JSONObject.parseObject(videoStr, VideoData.class);
        videoDataRepository.save(videoData);
    }

    @PostMapping("/video/list")
    public String list(@RequestParam(name = "targetId") Integer targetId){
        Target target = targetRepository.findById(targetId).get();
        return JSONArray.toJSONString(videoDataRepository.findByTarget(target));
    }
}
