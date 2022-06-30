package com.proti.hrworker.service;

import com.proti.hrworker.model.entities.Worker;
import com.proti.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository repository;

    public List<Worker> findAll() {
        return repository.findAll();
    }

    public Worker findById(@PathVariable("id") Long id) {
        return repository.findById(id).orElseThrow();
    }

}
