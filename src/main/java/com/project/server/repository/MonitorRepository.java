package com.project.server.repository;

import com.project.server.entity.Monitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonitorRepository extends JpaRepository<Monitor, Integer> {
    public List<Monitor> findByIdNumber(String idNumber);

    @Query("select m from Monitor m where m.name like ?1")
    public Page<Monitor> findByKeyword(String keyword, Pageable pageable);

    @Query("select m from Monitor m where m.name like ?1")
    public List<Monitor> findByKeyword(String keywords);
}
