package com.mentorondemand.repo;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.PaymentHistory;

public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Long> {

}
