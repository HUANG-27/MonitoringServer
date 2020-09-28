package com.project.server.repository;

import com.project.server.entity.Mission;
import com.project.server.entity.MissionType;
import com.project.server.entity.Monitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
    public List<Mission> findByType(MissionType type);

    @Query("select m from Mission m where m.name like ?1")
    public Page<Mission> findByKeyword(String keyword, Pageable pageable);
}
