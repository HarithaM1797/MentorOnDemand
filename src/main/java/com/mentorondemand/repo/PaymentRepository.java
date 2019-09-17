package com.mentorondemand.repo;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.Payments;

public interface PaymentRepository extends CrudRepository<Payments, Long> {

}
