package com.project.server.entity;

import com.project.server.converter.MissionTypeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Convert(converter = MissionTypeConverter.class)
    private MissionType type;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @OneToMany(mappedBy = "mission")
    private List<Monitor> monitors;
    @OneToMany(mappedBy = "mission")
    private List<Target> targets;
    @OneToMany(mappedBy = "mission")
    private List<UAV> uavs;

    public Mission(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MissionType getType() {
        return type;
    }

    public void setType(MissionType type) {
        this.type = type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<Monitor> getMonitors() {
        return monitors;
    }

    public void setMonitors(List<Monitor> monitors) {
        this.monitors = monitors;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public List<UAV> getUavs() {
        return uavs;
    }

    public void setUavs(List<UAV> uavs) {
        this.uavs = uavs;
    }
}
