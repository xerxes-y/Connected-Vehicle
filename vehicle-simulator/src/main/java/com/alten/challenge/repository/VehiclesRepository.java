package com.alten.challenge.repository;

import com.alten.challenge.model.Vehicle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesRepository extends ReactiveMongoRepository<Vehicle, String> {

}
