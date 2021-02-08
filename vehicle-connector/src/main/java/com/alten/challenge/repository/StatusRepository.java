package com.alten.challenge.repository;

import com.alten.challenge.model.Status;
import com.alten.challenge.model.StatusDetail;
import com.alten.challenge.model.Vehicle;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StatusRepository extends ReactiveMongoRepository<Status, String> {
    Flux<Status> findByCustomerId(String customerId);
    Mono<Status> findTopByVin(String vin);
    Flux<Status> findByStatusDetail(StatusDetail statusDetail);

}
