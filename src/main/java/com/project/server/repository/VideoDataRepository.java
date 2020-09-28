package com.project.server.repository;

import com.project.server.entity.Target;
import com.project.server.entity.VideoData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoDataRepository extends JpaRepository<VideoData, Integer> {
    public List<VideoData> findByTarget(Target target);
}
