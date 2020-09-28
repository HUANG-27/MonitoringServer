package com.project.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.project.server.entity.UAV;
import com.project.server.repository.UAVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
public class UAVController {
    @Autowired
    private UAVRepository uavRepository;

    @RequestMapping("/uav/list")
    public String list(){
        List<UAV> uavList = uavRepository.findAll();
        return JSONArray.toJSONString(uavList);
    }

    @RequestMapping("/list_uav")
    public String list(String keyword, Model model, Pageable pageable) {
        model.addAttribute("keyword", keyword);
        String keywordForSearch;
        if (keyword == null)
            keywordForSearch = "%%";
        else
            keywordForSearch = "%" + keyword + "%";
        Page<UAV> uavs = uavRepository.findByKeyword(keywordForSearch, pageable);
        model.addAttribute("pages", uavs);
        return "list_uav";
    }


    @GetMapping("/add_uav")
    public String addUAV(Model model){
        UAV uav = new UAV();
        model.addAttribute("uav", uav);
        return "/edit_uav";
    }

    @GetMapping("/edit_uav/{id}")
    public String editUAV(@PathVariable(name="id", required = true)Integer id, Model model){
        UAV uav = uavRepository.findById(id).get();
        model.addAttribute("uav", uav);
        return "/edit_uav";
    }

    @GetMapping("/delete_uav/{id}")
    public String deleteUAV(@PathVariable(name="id", required = true)Integer id){
        uavRepository.deleteById(id);
        return "redirect:/list_uav";
    }

    @PostMapping("/save_uav")
    public String saveUAV(@Valid UAV uav, BindingResult result){
        try{
            if(result.hasErrors()){
                System.out.println(Objects.requireNonNull(result.getFieldError()).toString());
                return "redirect:/edit_uav";
            }
            uavRepository.save(uav);
            return "redirect:/list_uav";
        }
        catch (Exception e){
            return "redirect:/edit_uav";
        }
    }
}
