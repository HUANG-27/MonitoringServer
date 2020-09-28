package com.project.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.Target;
import com.project.server.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class TargetController {
    @Autowired
    private TargetRepository targetRepository;

    @PostMapping("/target/save")
    public String save(@RequestParam(name = "target") String targetStr){
        Target target = JSONObject.parseObject(targetStr, Target.class);
        targetRepository.save(target);
        return JSONObject.toJSONString(target);
    }

    @PostMapping("/target/edit")
    public String edit(@RequestParam(name = "target") String targetStr){
        Target target = JSONObject.parseObject(targetStr, Target.class);
        targetRepository.save(target);
        return JSONObject.toJSONString(target);
    }

    @GetMapping("/target/list")
    public String list(){
        return JSONArray.toJSONString(targetRepository.findAll());
    }


    @RequestMapping("/list_target")
    public String list(String keyword, Model model, Pageable pageable) {
        model.addAttribute("keyword", keyword);
        String keywordForSearch;
        if (keyword == null)
            keywordForSearch = "%%";
        else
            keywordForSearch = "%" + keyword + "%";
        Page<Target> targets = targetRepository.findByKeyword(keywordForSearch, pageable);
        model.addAttribute("pages", targets);
        return "list_target";
    }

    @GetMapping("/add_target")
    public String addTarget(Model model){
        Target target = new Target();
        model.addAttribute("target", target);
        List<String> sexes = new ArrayList<>();
        sexes.add("男");
        sexes.add("女");
        model.addAttribute("sexes", sexes);
        return "/edit_target";
    }

    @GetMapping("/edit_target/{id}")
    public String editTarget(@PathVariable(name="id", required = true)Integer id, Model model){
        Target target = targetRepository.findById(id).get();
        model.addAttribute("target", target);
        List<String> sexes = new ArrayList<>();
        sexes.add("男");
        sexes.add("女");
        model.addAttribute("sexes", sexes);
        return "/edit_target";
    }

    @GetMapping("/delete_target/{id}")
    public String deleteTarget(@PathVariable(name="id", required = true)Integer id){
        targetRepository.deleteById(id);
        return "redirect:/list_target";
    }

    @PostMapping("/save_target")
    public String saveTarget(@Valid Target target, BindingResult result, Model model){
        try{
            if(result.hasErrors()){
                System.out.println(Objects.requireNonNull(result.getFieldError()).toString());
                return "redirect:/edit_target";
            }
            if(target.getId() != null && target.getId() > 0){
                Target target1 = targetRepository.findById(target.getId()).get();
                target.setId(target1.getId());
            }
            targetRepository.save(target);
            model.addAttribute("target", target);
            return "/info_target";
        }
        catch (Exception e){
            return "redirect:/edit_target";
        }
    }

    @GetMapping("/info_target/{id}")
    public String getInfoTarget(@PathVariable(name="id", required = true)Integer id, Model model){
        Target target = targetRepository.findById(id).get();
        model.addAttribute("target", target);
        return "/info_target";
    }
}
