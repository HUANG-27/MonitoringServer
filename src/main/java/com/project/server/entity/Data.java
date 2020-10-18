package com.project.server.entity;

import com.project.server.converter.CoordinateListConverter;
import com.project.server.converter.DataTypeConverter;
import com.project.server.converter.OrientationListConverter;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Data implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Convert(converter = DataTypeConverter.class)
    private DataType type;
    @ManyToOne
    private Target target;   //数据表述的目标对象
    @ManyToOne
    private Monitor monitor; //数据采集人
    private String title;
    private String content;
    private String uri;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Convert(converter = CoordinateListConverter.class)
    private List<Coordinate> locations;
    @Convert(converter = OrientationListConverter.class)
    private List<Orientation> orientations;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id.equals(data.id) &&
                type == data.type &&
                Objects.equals(target, data.target) &&
                Objects.equals(monitor, data.monitor) &&
                Objects.equals(title, data.title) &&
                Objects.equals(content, data.content) &&
                Objects.equals(uri, data.uri) &&
                Objects.equals(startTime, data.startTime) &&
                Objects.equals(endTime, data.endTime) &&
                Objects.equals(locations, data.locations) &&
                Objects.equals(orientations, data.orientations) &&
                Objects.equals(description, data.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, target, monitor, title, content, uri, startTime, endTime, locations, orientations, description);
    }
}
