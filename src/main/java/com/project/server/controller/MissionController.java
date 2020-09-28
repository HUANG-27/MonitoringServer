package com.project.server.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.*;
import com.project.server.repository.MissionRepository;
import com.project.server.repository.MonitorRepository;
import com.project.server.repository.TargetRepository;
import com.project.server.repository.UAVRepository;
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
import java.util.Map;
import java.util.Objects;

@Controller
public class MissionController {
    @Autowired
    public MissionRepository missionRepository;
    @Autowired
    public MonitorRepository monitorRepository;
    @Autowired
    public TargetRepository targetRepository;
    @Autowired
    public UAVRepository uavRepository;

    @RequestMapping("/list_mission")
    public String list(String keyword, Model model, Pageable pageable) {
        model.addAttribute("keyword", keyword);
        String keywordForSearch;
        if (keyword == null)
            keywordForSearch = "%%";
        else
            keywordForSearch = "%" + keyword + "%";
        Page<Mission> missions = missionRepository.findByKeyword(keywordForSearch, pageable);
        model.addAttribute("pages", missions);
        return "list_mission";
    }

    @GetMapping("/add_mission")
    public String addMission(Model model) {
        Mission mission = new Mission();
        model.addAttribute("types", MissionType.toList());
        model.addAttribute("mission", mission);
        return "/edit_mission";
    }

    @GetMapping("/edit_mission/{id}")
    public String editMission(@PathVariable(name = "id", required = true) Integer id, Model model) {
        Mission mission = missionRepository.findById(id).get();
        model.addAttribute("types", MissionType.toList());
        model.addAttribute("mission", mission);
        return "/edit_mission";
    }

    @GetMapping("/delete_mission/{id}")
    public String deleteMission(@PathVariable(name = "id", required = true) Integer id) {
        missionRepository.deleteById(id);
        return "redirect:/list_mission";
    }

    @PostMapping("/save_mission")
    public String saveMission(@Valid Mission mission, BindingResult result) {
        try {
            if (result.hasErrors()) {
                System.out.println(Objects.requireNonNull(result.getFieldError()).toString());
                return "redirect:/edit_mission";
            }
            if (mission.getId() != null && mission.getId() > 0) {
                Mission mission1 = missionRepository.findById(mission.getId()).get();
                mission.setId(mission1.getId());
            }
            missionRepository.save(mission);
            return "/info_mission/" + mission.getId();
        } catch (Exception e) {
            return "redirect:/edit_mission";
        }
    }

    @GetMapping("/info_mission/{id}")
    public String getInfoMission(@PathVariable(name = "id", required = true) Integer id, Model model) {
        Mission mission = missionRepository.findById(id).get();
        model.addAttribute("mission", mission);
        return "/info_mission";
    }

    @RequestMapping("/check_target/{id}")
    public String checkTarget(@PathVariable(name = "id", required = true) Integer id, String keyword, Model model) {
        Mission mission = missionRepository.findById(id).get();
        model.addAttribute("mission", mission);
        model.addAttribute("keyword", keyword);
        String keywordForSearch;
        if (keyword == null)
            keywordForSearch = "%%";
        else
            keywordForSearch = "%" + keyword + "%";
        List<Target> targets = targetRepository.findByKeyword(keywordForSearch);
        model.addAttribute("targets", targets);
        return "/check_target";
    }

    @PostMapping("/check_target_finish")
    public String checkTargetFinish(@RequestBody Map<String, Object> parameterMap, Model model) {
        String missionId = parameterMap.get("mission_id").toString();
        Mission mission = missionRepository.findById(Integer.parseInt(missionId)).get();
        List<Target> targets = new ArrayList<>();
        List<String> targetIds = JSONArray.parseArray(parameterMap.get("target_ids").toString(), String.class);
        for(String targetId : targetIds){
            Target target = targetRepository.findById(Integer.parseInt(targetId)).get();
            targets.add(target);
            target.setMission(mission);
            targetRepository.save(target);
        }
        mission.setTargets(targets);
        missionRepository.save(mission);
        model.addAttribute("mission", mission);
        return "/info_mission";
    }

    @RequestMapping("/check_monitor/{id}")
    public String checkMonitor(@PathVariable(name = "id", required = true) Integer id, String keyword, Model model) {
        Mission mission = missionRepository.findById(id).get();
        model.addAttribute("mission", mission);
        model.addAttribute("keyword", keyword);
        String keywordForSearch;
        if (keyword == null)
            keywordForSearch = "%%";
        else
            keywordForSearch = "%" + keyword + "%";
        List<Monitor> monitors = monitorRepository.findByKeyword(keywordForSearch);
        model.addAttribute("monitors", monitors);
        return "/check_monitor";
    }

    @RequestMapping("/check_monitor_finish")
    public String checkMonitorFinish(@RequestBody Map<String, Object> parameterMap, Model model) {
        String missionId = parameterMap.get("mission_id").toString();
        Mission mission = missionRepository.findById(Integer.parseInt(missionId)).get();
        List<Monitor> monitors = new ArrayList<>();
        List<String> monitorIds = JSONArray.parseArray(parameterMap.get("monitor_ids").toString(), String.class);
        for(String monitorId : monitorIds){
            Monitor monitor = monitorRepository.findById(Integer.parseInt(monitorId)).get();
            monitors.add(monitor);
            monitor.setMission(mission);
            monitorRepository.save(monitor);
        }
        mission.setMonitors(monitors);
        missionRepository.save(mission);
        model.addAttribute("mission", mission);
        return "/info_mission";
    }

    @RequestMapping("/check_uav/{id}")
    public String checkUAV(@PathVariable(name = "id", required = true) Integer id, String keyword, Model model) {
        Mission mission = missionRepository.findById(id).get();
        model.addAttribute("mission", mission);
        model.addAttribute("keyword", keyword);
        String keywordForSearch;
        if (keyword == null)
            keywordForSearch = "%%";
        else
            keywordForSearch = "%" + keyword + "%";
        List<UAV> uavs = uavRepository.findByKeyword(keywordForSearch);
        model.addAttribute("uavs", uavs);
        return "/check_uav";
    }

    @RequestMapping("/check_uav_finish")
    public String checkUAVFinish(@RequestBody Map<String, Object> parameterMap, Model model) {
        String missionId = parameterMap.get("mission_id").toString();
        Mission mission = missionRepository.findById(Integer.parseInt(missionId)).get();
        List<UAV> uavs = new ArrayList<>();
        List<String> uavIds = JSONArray.parseArray(parameterMap.get("uav_ids").toString(), String.class);
        for(String uavId : uavIds){
            UAV uav = uavRepository.findById(Integer.parseInt(uavId)).get();
            uavs.add(uav);
            uav.setMission(mission);
            uavRepository.save(uav);
        }
        mission.setUavs(uavs);
        missionRepository.save(mission);
        model.addAttribute("mission", mission);
        return "/info_mission";
    }

}
