package com.project.server.converter;

import com.project.server.entity.MissionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MissionTypeConverter implements AttributeConverter<MissionType, String> {

    @Override
    public String convertToDatabaseColumn(MissionType missionType) {
        return missionType.toString();
    }

    @Override
    public MissionType convertToEntityAttribute(String s) {
        return MissionType.valueOf(s);
    }
}
