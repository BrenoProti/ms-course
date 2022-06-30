package com.proti.hrworker.repositories;

import com.proti.hrworker.model.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
