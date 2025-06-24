package com.gocevd.petstore.repository.jpa;

import com.gocevd.petstore.model.HistoryLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface HistoryLogRepository extends JpaRepository<HistoryLog, LocalDateTime> {
}
