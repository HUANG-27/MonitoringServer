package com.project.server.repository;

import com.project.server.entity.Target;
import com.project.server.entity.TextData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextDataRepository extends JpaRepository<TextData, Integer> {
    public List<TextData> findByTarget(Target target);
}
