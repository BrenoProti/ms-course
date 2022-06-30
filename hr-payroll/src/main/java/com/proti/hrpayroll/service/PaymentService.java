package com.proti.hrpayroll.service;

import com.proti.hrpayroll.model.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days) {
        return new Payment("Bob", 200.00, days);
    }
}
