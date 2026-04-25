package com.nms.fm.repository;

import com.nms.fm.entity.Fault;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaultRepository extends JpaRepository<Fault, Long> {
}