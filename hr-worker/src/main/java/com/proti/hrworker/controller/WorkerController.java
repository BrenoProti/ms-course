package com.proti.hrworker.controller;

import com.proti.hrworker.model.entities.Worker;
import com.proti.hrworker.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/workers")
public class WorkerController {

    @Value("${test.config}")
    private String testConfig;

    private final Environment env;

    private final WorkerService service;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
         return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
        log.info("PORT ".concat(env.getProperty("local.server.port")));
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/config")
    public ResponseEntity<String> config() {
        log.info("config = " + testConfig);
        return ResponseEntity.ok(testConfig);
    }
}
