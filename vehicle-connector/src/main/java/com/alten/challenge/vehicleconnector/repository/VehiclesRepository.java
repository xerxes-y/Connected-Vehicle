package com.alten.challenge.vehicleconnector.repository;

import com.alten.challenge.vehicleconnector.model.Vehicle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.xml.transform.sax.SAXTransformerFactory;

@Repository
public interface VehiclesRepository extends ReactiveMongoRepository<Vehicle, String> {
    Mono<Vehicle> findByVin(String vin );
    Flux<Vehicle> findByCustomerId(String customerId);
    
    
}
