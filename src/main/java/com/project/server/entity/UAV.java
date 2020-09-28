package com.project.server.entity;

import com.project.server.converter.CoordinateConverter;
import com.project.server.converter.OrientationConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class UAV implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String model;

    private Boolean active;

    @ManyToOne
    private Mission mission;

    @Convert(converter = CoordinateConverter.class)
    private Coordinate location;

    @Convert(converter = OrientationConverter.class)
    private Orientation orientation;

    private String imageUri;

    public UAV() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UAV)) return false;
        UAV uav = (UAV) o;
        return getId().equals(uav.getId()) &&
                Objects.equals(getName(), uav.getName()) &&
                Objects.equals(getModel(), uav.getModel()) &&
                Objects.equals(getLocation(), uav.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getModel(), getLocation());
    }
}
