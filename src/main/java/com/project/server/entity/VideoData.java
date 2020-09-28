package com.project.server.entity;

import com.project.server.converter.CoordinateListConverter;
import com.project.server.converter.OrientationListConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class VideoData extends Data {

    @NotNull
    private LocalDateTime startTime;
    @NotNull
    private LocalDateTime endTime;
    @NotNull
    private String uri;
    @NotNull
    @Convert(converter = CoordinateListConverter.class)
    private List<Coordinate> locations; //每5秒采集一次位置信息
    @NotNull
    @Convert(converter = OrientationListConverter.class)
    private List<Orientation> orientations; //每一帧采集一次姿态数据

    public VideoData() {
        super();
        setType(DataType.VIDEO_DATA);
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

    public List<Orientation> getOrientations() {
        return orientations;
    }

    public void setOrientations(List<Orientation> orientations) {
        this.orientations = orientations;
    }

}
