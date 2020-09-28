package com.project.server.repository;

import com.project.server.entity.Target;
import com.project.server.entity.AudioData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AudioDataRepository extends JpaRepository<AudioData, Integer> {
    public List<AudioData> findByTarget(Target target);
}
