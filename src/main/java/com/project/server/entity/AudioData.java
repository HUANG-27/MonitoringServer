package com.project.server.entity;

import com.project.server.converter.CoordinateListConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class AudioData extends Data {

    @NotNull
    private LocalDateTime startTime;
    @NotNull
    private LocalDateTime endTime;
    @NotNull
    private String uri;
    @NotNull
    @Convert(converter = CoordinateListConverter.class)
    private List<Coordinate> locations; //每0.05秒采集一次位置信息

    public AudioData() {
        super();
        setType(DataType.AUDIO_DATA);
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Coordinate> getLocations() {
        return locations;
    }

    public void setLocations(List<Coordinate> locations) {
        this.locations = locations;
    }

}
