package com.project.server.repository;

import com.project.server.entity.Monitor;
import com.project.server.entity.UAV;
import com.project.server.entity.UAVData;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;

public interface UAVDataRepository extends JpaRepository<UAVData, Integer> {

}
