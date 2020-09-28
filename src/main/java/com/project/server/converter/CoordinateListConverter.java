package com.project.server.converter;

import com.alibaba.fastjson.JSONArray;
import com.project.server.entity.Coordinate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class CoordinateListConverter implements AttributeConverter<List<Coordinate>, String> {
    @Override
    public String convertToDatabaseColumn(List<Coordinate> coordinates) {
        return JSONArray.toJSONString(coordinates);
    }

    @Override
    public List<Coordinate> convertToEntityAttribute(String s) {
        return JSONArray.parseArray(s, Coordinate.class);
    }
}
