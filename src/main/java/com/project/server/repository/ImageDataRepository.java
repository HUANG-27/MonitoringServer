package com.project.server.repository;

import com.project.server.entity.Target;
import com.project.server.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDataRepository extends JpaRepository<ImageData, Integer> {
    public List<ImageData> findByTarget(Target target);
}
