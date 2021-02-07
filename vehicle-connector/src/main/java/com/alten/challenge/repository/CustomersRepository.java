package com.alten.challenge.repository;

import com.alten.challenge.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomersRepository extends ReactiveMongoRepository<Customer,String> {
    Mono<Customer> findByFullName(String fullName);
}
