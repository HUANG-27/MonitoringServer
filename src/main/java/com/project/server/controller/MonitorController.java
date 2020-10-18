package com.project.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.Monitor;
import com.project.server.entity.Coordinate;
import com.project.server.repository.MonitorRepository;
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
public class MonitorController {
    @Autowired
    private MonitorRepository monitorRepository;

    @PostMapping("/monitor/register")
    public @ResponseBody String register(@RequestBody Monitor monitor) {
        try {
            monitor.setState(true);
            monitorRepository.save(monitor);
            return JSONObject.toJSONString(monitor);
        } catch (Exception ex) {
            return null;
        }

    }

    @PostMapping("/monitor/login")
    public @ResponseBody String login(@RequestParam(name = "phone_number") String phoneNumber,
                        @RequestParam(name = "password") String password) {
        Monitor monitor = monitorRepository.findByTel(phoneNumber).get(0);
        if (password.equals(monitor.getPassword())) {
            monitor.setState(true);
            monitorRepository.save(monitor);
            return JSONObject.toJSONString(monitor);
        }
        return null;
    }

    @PostMapping("/monitor/logout")
    public @ResponseBody String logout(@RequestParam(name = "id") Integer id) {
        Monitor monitor = monitorRepository.findById(id).get();
        monitor.setState(false);
        monitorRepository.save(monitor);
        boolean res = !monitor.getState();
        return String.valueOf(res);
    }

    @PostMapping("/monitor/update_loc")
    public @ResponseBody String updateLocation(@RequestParam(name = "id") Integer id,
                               @RequestParam(name = "location") String locationStr) {
        Monitor monitor = monitorRepository.findById(id).get();
        monitor.setLocation(JSONObject.parseObject(locationStr, Coordinate.class));
        monitorRepository.save(monitor);
        return "bingo";
    }

    @PostMapping("/edit")
    public @ResponseBody String edit(@RequestBody Monitor monitor) {
        monitorRepository.save(monitor);
        return JSONObject.toJSONString(monitor);
    }

    @PostMapping("/get")
    public @ResponseBody String get(@RequestParam(name = "id") Integer id) {
        return JSONObject.toJSONString(monitorRepository.findById(id).get());
    }

    @RequestMapping("/list_monitor")
    public String list(String keyword, Model model, Pageable pageable) {
        model.addAttribute("keyword", keyword);
        String keywordForSearch;
        if (keyword == null)
            keywordForSearch = "%%";
        else
            keywordForSearch = "%" + keyword + "%";
        Page<Monitor> monitors = monitorRepository.findByKeyword(keywordForSearch, pageable);
        model.addAttribute("pages", monitors);
        return "list_monitor";
    }


    @GetMapping("/add_monitor")
    public String addMonitor(Model model){
        Monitor monitor = new Monitor();
        monitor.setPassword("12345678");
        model.addAttribute("monitor", monitor);
        List<String> sexes = new ArrayList<>();
        sexes.add("男");
        sexes.add("女");
        model.addAttribute("sexes", sexes);
        return "/edit_monitor";
    }

    @GetMapping("/edit_monitor/{id}")
    public String editMonitor(@PathVariable(name="id", required = true)Integer id, Model model){
        Monitor monitor = monitorRepository.findById(id).get();
        model.addAttribute("monitor", monitor);
        List<String> sexes = new ArrayList<>();
        sexes.add("男");
        sexes.add("女");
        model.addAttribute("sexes", sexes);
        return "/edit_monitor";
    }

    @GetMapping("/delete_monitor/{id}")
    public String deleteMonitor(@PathVariable(name="id", required = true)Integer id){
        monitorRepository.deleteById(id);
        return "redirect:/list_monitor";
    }

    @PostMapping("/save_monitor")
    public String saveMonitor(@Valid Monitor monitor, BindingResult result){
        try{
            if(result.hasErrors()){
                System.out.println(Objects.requireNonNull(result.getFieldError()).toString());
                return "redirect:/edit_monitor";
            }
            monitorRepository.save(monitor);
            return "redirect:/list_monitor";
        }
        catch (Exception e){
            return "redirect:/edit_monitor";
        }
    }
}
