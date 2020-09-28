package com.project.server.entity;

import com.project.server.converter.CoordinateConverter;
import com.project.server.converter.OrientationConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class UAVData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private UAV uav;
    @NotNull
    private LocalDateTime time;
    @NotNull
    @Convert(converter = CoordinateConverter.class)
    private Coordinate location;
    @NotNull
    @Convert(converter = OrientationConverter.class)
    private Orientation orientation;
    @NotNull
    private String imageName;
    @NotNull
    private String imageUri;
    @NotNull
    @Convert(converter = CoordinateConverter.class)
    private Coordinate targetLocation;


    public UAVData(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UAV getUav() {
        return uav;
    }

    public void setUav(UAV uav) {
        this.uav = uav;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public Coordinate getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(Coordinate targetLocation) {
        this.targetLocation = targetLocation;
    }
}
