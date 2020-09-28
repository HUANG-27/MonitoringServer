package com.project.server.entity;

import java.util.ArrayList;
import java.util.List;

public enum MissionType {
    围捕,
    搜索;

    public static List<String> toList(){
        MissionType[] missionTypes = MissionType.values();
        List<String> strMissions = new ArrayList<>();
        for(MissionType missionType : missionTypes){
            strMissions.add(missionType.name());
//            if(missionType == MissionType.ROUND_UP)
//                strMissions.add("围捕");
//            else if(missionType == MissionType.SEARCH)
//                strMissions.add("搜索");
//            else
//                strMissions.add("其他");
        }
        return strMissions;
    }
}
