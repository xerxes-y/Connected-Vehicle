package com.alten.challenge.vehicleconnector.repository;

import com.alten.challenge.vehicleconnector.model.Status;
import com.alten.challenge.vehicleconnector.model.StatusDetailReceiver;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StatusRepository extends ReactiveMongoRepository<Status, String> {
    Mono<Status> findTopByCustomerId(String customerId);
    Mono<Status> findTopByVin(String vin);
    Flux<Status> findByStatusDetail(StatusDetailReceiver statusDetail);

}
