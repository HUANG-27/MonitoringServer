package com.project.server.converter;

import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.Orientation;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OrientationConverter implements AttributeConverter<Orientation, String> {
    @Override
    public String convertToDatabaseColumn(Orientation orientation) {
        return JSONObject.toJSONString(orientation);
    }

    @Override
    public Orientation convertToEntityAttribute(String s) {
        return JSONObject.parseObject(s, Orientation.class);
    }
}
