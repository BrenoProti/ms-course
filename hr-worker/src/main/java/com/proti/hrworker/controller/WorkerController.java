package com.proti.hrworker.controller;

import com.proti.hrworker.model.entities.Worker;
import com.proti.hrworker.repositories.WorkerRepository;
import com.proti.hrworker.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/workers")
public class WorkerController {

    private final WorkerService service;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
         return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
