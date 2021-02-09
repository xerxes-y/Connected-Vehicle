package com.alten.challenge.vehiclesimulator.repository;

import com.alten.challenge.vehiclesimulator.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomersRepository extends ReactiveMongoRepository<Customer,String> {
    Mono<Customer> findByFullName(String fullName);
}
