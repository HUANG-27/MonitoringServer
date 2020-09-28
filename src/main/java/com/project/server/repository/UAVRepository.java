package com.project.server.repository;

import com.project.server.entity.UAV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UAVRepository extends JpaRepository<UAV, Integer> {

    @Query("select u from UAV u where u.name like ?1")
    public Page<UAV> findByKeyword(String keyword, Pageable pageable);

    @Query("select u from UAV u where u.name like ?1")
    public List<UAV> findByKeyword(String keyword);
}
