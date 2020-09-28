package com.project.server.entity;

import com.project.server.converter.CoordinateConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "id_number")})
public class Monitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String idNumber;
    @NotNull
    private String name;
    private String iconUri;
    @NotNull
    private String tel;
    @NotNull
    @Size(min=8)
    private String password;
    private String gender;
    private String nation;

    @Convert(converter = CoordinateConverter.class)
    private List<Coordinate> path;
    @ManyToOne
    private Mission mission;
    private Boolean state;
    private String officePlace;
    private String officeDuty;
    @Convert(converter = CoordinateConverter.class)
    private Coordinate location;
    private String tag;

    public Monitor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUri() {
        return iconUri;
    }

    public void setIconUri(String iconUri) {
        this.iconUri = iconUri;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public List<Coordinate> getPath() {
        return path;
    }

    public void setPath(List<Coordinate> path) {
        this.path = path;
    }

    public String getOfficePlace() {
        return officePlace;
    }

    public void setOfficePlace(String officePlace) {
        this.officePlace = officePlace;
    }

    public String getOfficeDuty() {
        return officeDuty;
    }

    public void setOfficeDuty(String officeDuty) {
        this.officeDuty = officeDuty;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monitor)) return false;
        Monitor monitor = (Monitor) o;
        return getId().equals(monitor.getId()) &&
                getIdNumber().equals(monitor.getIdNumber()) &&
                Objects.equals(getName(), monitor.getName()) &&
                Objects.equals(getIconUri(), monitor.getIconUri()) &&
                getTel().equals(monitor.getTel()) &&
                Objects.equals(getPassword(), monitor.getPassword()) &&
                Objects.equals(getGender(), monitor.getGender()) &&
                Objects.equals(getNation(), monitor.getNation()) &&
                Objects.equals(getOfficePlace(), monitor.getOfficePlace()) &&
                Objects.equals(getOfficeDuty(), monitor.getOfficeDuty()) &&
                Objects.equals(getLocation(), monitor.getLocation()) &&
                Objects.equals(getTag(), monitor.getTag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdNumber(), getName(), getIconUri(), getTel(), getPassword(), getGender(), getNation(), getOfficePlace(), getOfficeDuty(), getLocation(), getTag());
    }
}
