package com.project.server.entity;

import com.project.server.converter.CoordinateConverter;
import com.project.server.converter.OrientationConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class ImageData extends Data implements Serializable {

    @NotNull
    private LocalDateTime time;
    @NotNull
    @Convert(converter = CoordinateConverter.class)
    private Coordinate location;
    @NotNull
    @Convert(converter = OrientationConverter.class)
    private Orientation orientation;
    @NotNull
    private String uri;

    public ImageData() {
        super();
        setType(DataType.IMAGE_DATA);
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
