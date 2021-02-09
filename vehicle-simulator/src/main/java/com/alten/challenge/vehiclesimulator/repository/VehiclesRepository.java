package com.alten.challenge.vehiclesimulator.repository;

import com.alten.challenge.vehiclesimulator.model.Vehicle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface VehiclesRepository extends ReactiveMongoRepository<Vehicle, String> {
    Mono<Vehicle> findByVinAndCustomerId(String vin ,String customerId);
}
