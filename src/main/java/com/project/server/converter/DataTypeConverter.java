package com.project.server.converter;

import com.project.server.entity.DataType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DataTypeConverter implements AttributeConverter<DataType, String> {
    @Override
    public String convertToDatabaseColumn(DataType dataType) {
        return dataType.toString();
    }

    @Override
    public DataType convertToEntityAttribute(String s) {
        return DataType.valueOf(s);
    }
}
