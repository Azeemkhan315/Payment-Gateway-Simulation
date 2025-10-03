package com.Payment.Gateway.Simulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Payment.Gateway.Simulation.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
