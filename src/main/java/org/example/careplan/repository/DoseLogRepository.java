package org.example.careplan.repository;

import org.example.careplan.entity.DoseLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseLogRepository extends JpaRepository<DoseLog, Long> {
}