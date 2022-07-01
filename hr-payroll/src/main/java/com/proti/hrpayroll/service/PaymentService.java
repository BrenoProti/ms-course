package com.proti.hrpayroll.service;

import com.proti.hrpayroll.model.entity.Payment;
import com.proti.hrpayroll.model.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;

    public Payment getPayment(Long workerId, Integer days) {
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", workerId.toString());
        String url = workerHost.concat("/workers/{id}");
        Worker worker = restTemplate.getForObject(url, Worker.class, uriVariable);
        assert worker != null;
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
