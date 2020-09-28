package com.project.server.repository;

import com.project.server.entity.Monitor;
import com.project.server.entity.Target;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TargetRepository extends JpaRepository<Target, Integer> {

    @Query("select t from Target t where t.name like ?1")
    public Page<Target> findByKeyword(String keyword, Pageable pageable);

    @Query("select t from Target t where t.name like ?1")
    public List<Target> findByKeyword(String keyword);
}
