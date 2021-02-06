package com.alten.challenge.repository;

import com.alten.challenge.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomersRepository extends ReactiveMongoRepository<Customer,String> {
}
