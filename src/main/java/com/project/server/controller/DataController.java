package com.project.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.Data;
import com.project.server.entity.Target;
import com.project.server.repository.DataRepository;
import com.project.server.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class DataController {
    @Autowired
    private DataRepository dataRepository;
    @Autowired
    private TargetRepository targetRepository;

    @PostMapping("/data/upload")
    public @ResponseBody String upload(@RequestParam(name="info") String info,
                                       @RequestParam(name="file") MultipartFile file) throws IOException {
        Data data = JSONObject.parseObject(info, Data.class);
        if(file != null && !file.isEmpty()){
            switch (data.getType()){
                case TEXT_DATA:
                    break;
                case IMAGE_DATA:
                case AUDIO_DATA:
                case VIDEO_DATA:
                    byte[] bytes = file.getBytes();
                    String filename = file.getOriginalFilename();
                    assert filename != null;
                    FileOutputStream fos = new FileOutputStream(new File(filename));
                    BufferedOutputStream stream = new BufferedOutputStream(fos);
                    stream.write(bytes);
                    stream.close();
                    break;
            }
        }
        dataRepository.save(data);
        Target target = data.getTarget();
        List<Data> dataList = target.getDataList();
        dataList.add(data);
        target.setDataList(dataList);
        targetRepository.save(target);
        return "upload successful";
    }

    @RequestMapping("/data/upload_only")
    public @ResponseBody String upload2(@RequestBody Data data){
        System.out.println(data.getContent());
        return "upload successful";
    }

//    public @ResponseBody String upload(HttpServletRequest request) throws IOException {
//        MultipartHttpServletRequest parts = (MultipartHttpServletRequest)request;
//        String strData = parts.getParameter("info");
//        Data data = JSONObject.parseObject(strData, Data.class);
//        MultipartFile file = parts.getFile("file");
//        if(file != null && !file.isEmpty()){
//            switch (data.getType()){
//                case TEXT_DATA:
//                    break;
//                case IMAGE_DATA:
//                case AUDIO_DATA:
//                case VIDEO_DATA:
//                    byte[] bytes = file.getBytes();
//                    String filename = file.getOriginalFilename();
//                    assert filename != null;
//                    FileOutputStream fos = new FileOutputStream(new File("./data/" + filename));
//                    BufferedOutputStream stream = new BufferedOutputStream(fos);
//                    stream.write(bytes);
//                    stream.close();
//                    break;
//            }
//        }
//        dataRepository.save(data);
//        Target target = data.getTarget();
//        List<Data> dataList = target.getDataList();
//        dataList.add(data);
//        target.setDataList(dataList);
//        targetRepository.save(target);
//        return "upload successful";
//    }

}
