package com.project.server.entity;

import com.project.server.converter.CoordinateConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Target implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;  //编号
    @NotNull
    @Column(unique = true)
    private String idNumber;    //身份证号
    private String name;    //姓名
    private String iconUri;    //照片
    private String tel;
    private String nation;  //民族
    private String gender;  //性别
    private Integer age;
    private Double height;   //身高
    private Double weight;   //体重
    private String idAddress;   //户籍所在地
    private String address; //现住址
    @ManyToOne
    private Mission mission;
    @Convert(converter = CoordinateConverter.class)
    private Coordinate location;

    @OneToMany(mappedBy = "target")
    private List<Data2> datas;

    private String description;
    private String tag;

    public Target() {
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public List<Data2> getDatas() {
        return datas;
    }

    public void setDatas(List<Data2> datas) {
        this.datas = datas;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(o instanceof Target)) return false;
        Target target = (Target) o;
        return getId().equals(target.getId()) &&
                Objects.equals(getIdNumber(), target.getIdNumber()) &&
                Objects.equals(getName(), target.getName()) &&
                Objects.equals(getIconUri(), target.getIconUri()) &&
                Objects.equals(getGender(), target.getGender()) &&
                Objects.equals(getNation(), target.getNation()) &&
                Objects.equals(getHeight(), target.getHeight()) &&
                Objects.equals(getWeight(), target.getWeight()) &&
                Objects.equals(getIdAddress(), target.getIdAddress()) &&
                Objects.equals(getAddress(), target.getAddress()) &&
                Objects.equals(getLocation(), target.getLocation()) &&
                Objects.equals(getDescription(), target.getDescription()) &&
                Objects.equals(getTag(), target.getTag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdNumber(), getName(), getIconUri(), getGender(), getNation(), getHeight(), getWeight(), getIdAddress(), getAddress(), getLocation(), getDescription(), getTag());
    }
}
