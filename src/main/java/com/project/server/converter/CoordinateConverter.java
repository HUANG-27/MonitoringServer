package com.project.server.converter;

import com.alibaba.fastjson.JSONObject;
import com.project.server.entity.Coordinate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CoordinateConverter implements AttributeConverter<Coordinate, String> {
    @Override
    public String convertToDatabaseColumn(Coordinate coordinate) {
        return JSONObject.toJSONString(coordinate);
    }

    @Override
    public Coordinate convertToEntityAttribute(String s) {
        return JSONObject.parseObject(s, Coordinate.class);
    }
}
