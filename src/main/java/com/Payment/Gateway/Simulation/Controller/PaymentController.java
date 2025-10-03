package com.Payment.Gateway.Simulation.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Payment.Gateway.Simulation.Entity.Payment;
import com.Payment.Gateway.Simulation.Repository.PaymentRepository;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepository repo;

    @PostMapping("/api/payment/initiate")
    public Payment initiatePayment(@RequestBody Map<String, Object> request) {

        // 1️⃣ Create new payment record
        Payment payment = new Payment();
        payment.setAmount(Double.valueOf(request.get("amount").toString()));
        payment.setMethod(request.get("method").toString());
        payment.setStatus("PENDING");

        // Save payment to DB
        Payment savedPayment = repo.save(payment);

        // 2️⃣ Call async method to simulate payment success
        simulatePaymentSuccess(savedPayment);

        // Return initial PENDING response
        return savedPayment;
    }

    // 3️⃣ Async method to update status after 5 sec
    @Async
    public void simulatePaymentSuccess(Payment payment) {
        try {
            Thread.sleep(5000); // wait for 5 sec
            Payment p = repo.findById(payment.getId()).orElseThrow();
            p.setStatus("SUCCESS");
            repo.save(p);
            System.out.println("Payment ID " + p.getId() + " marked SUCCESS ✅");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
