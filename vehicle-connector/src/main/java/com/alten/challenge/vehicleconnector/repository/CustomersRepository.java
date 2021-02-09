package com.alten.challenge.vehicleconnector.repository;

import com.alten.challenge.vehicleconnector.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomersRepository extends ReactiveMongoRepository<Customer,String> {
    Mono<Customer> findByFullNameStartingWith(String fullName);
}
