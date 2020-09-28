package com.project.server.entity;

import com.project.server.converter.DataTypeConverter;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@MappedSuperclass
public class Data implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Convert(converter = DataTypeConverter.class)
    private DataType type;
    @ManyToOne(targetEntity = Target.class)
    private Target target;   //数据表述的目标对象

    @ManyToOne
    private Monitor monitor; //数据采集人

    private String description;

    public Data() {
        this.setType(DataType.DEFAULT);
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
