package com.project.server.entity;

import com.project.server.converter.CoordinateConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class TextData extends Data {

    @NotNull
    private String title;
    @NotNull
    @Lob
    private String content;
    @NotNull
    private LocalDateTime time;
    @NotNull
    @Convert(converter = CoordinateConverter.class)
    private Coordinate location;

    public TextData() {
        super();
        setType(DataType.TEXT_DATA);
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

}
