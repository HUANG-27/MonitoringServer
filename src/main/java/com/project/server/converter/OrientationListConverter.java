package com.project.server.converter;

import com.alibaba.fastjson.JSONArray;
import com.project.server.entity.Orientation;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class OrientationListConverter implements AttributeConverter<List<Orientation>, String> {
    @Override
    public String convertToDatabaseColumn(List<Orientation> orientations) {
        return JSONArray.toJSONString(orientations);
    }

    @Override
    public List<Orientation> convertToEntityAttribute(String s) {
        return JSONArray.parseArray(s, Orientation.class);
    }
}
