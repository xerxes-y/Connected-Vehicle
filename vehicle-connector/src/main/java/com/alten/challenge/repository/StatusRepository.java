package com.alten.challenge.repository;

import com.alten.challenge.model.Status;
import com.alten.challenge.model.Vehicle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StatusRepository extends ReactiveMongoRepository<Status, String> {
}
