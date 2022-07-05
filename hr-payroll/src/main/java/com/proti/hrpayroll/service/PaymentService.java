package com.proti.hrpayroll.service;

import com.proti.hrpayroll.client.WorkerClient;
import com.proti.hrpayroll.model.entity.Payment;
import com.proti.hrpayroll.model.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerClient workerClient;

    public Payment getPayment(Long workerId, Integer days) {
        Worker worker = this.workerClient.findById(workerId).getBody();
        assert worker != null;
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
