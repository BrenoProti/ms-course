package com.proti.hrpayroll.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.proti.hrpayroll.model.entity.Payment;
import com.proti.hrpayroll.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    private final PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymanetAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId, @PathVariable("days") Integer days) {
        return ResponseEntity.ok(service.getPayment(workerId, days));
    }

    public ResponseEntity<Payment> getPaymanetAlternative(@PathVariable("workerId") Long workerId, @PathVariable("days") Integer days) {
        Payment payment = new Payment("Brann", 400.0, days);
        return ResponseEntity.ok(payment);
    }



}
