package com.project.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.Target;
import com.project.server.entity.AudioData;
import com.project.server.repository.AudioDataRepository;
import com.project.server.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AudioDataController {
    @Autowired
    private AudioDataRepository audioDataRepository;
    @Autowired
    private TargetRepository targetRepository;

    @PostMapping("/audio/upload")
    public void upload(@RequestParam(name = "audio") String audioStr){
        AudioData audioData = JSONObject.parseObject(audioStr, AudioData.class);
        audioDataRepository.save(audioData);
    }

    @PostMapping("/audio/list")
    public String list(@RequestParam(name="targetId") Integer targetId){
        Target target = targetRepository.findById(targetId).get();
        return JSONArray.toJSONString(audioDataRepository.findByTarget(target));
    }
}
