package com.alten.challenge.vehiclesimulator;


import com.alten.challenge.vehiclesimulator.model.Customer;
import com.alten.challenge.vehiclesimulator.model.Vehicle;
import com.alten.challenge.vehiclesimulator.repository.CustomersRepository;
import com.alten.challenge.vehiclesimulator.repository.VehiclesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = VehicleSimulatorApplication.class)
public class VehicleRepositoryManualTest {

    @Autowired
    VehiclesRepository vehicleRepository;
    @Autowired
    CustomersRepository customersRepository;

    @Test
    public void givenExample_whenFindAllWithExample_thenFindAllMacthings() {
        customersRepository.save(Customer.builder().address("tehran").fullName("khasyar yadmand").build()).subscribe(customer -> {
            vehicleRepository.save( Vehicle.builder().vin("121212").regNr("3333").availability(true).customerId(customer.getId()).build()).subscribe(s -> {
                ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("owne    r", startsWith());
                Example<Vehicle> example = Example.of( Vehicle.builder().vin("121212").build(), matcher);
                Flux<Vehicle> vehicleFlux = vehicleRepository.findAll(example);
                StepVerifier
                        .create(vehicleFlux)
                        .assertNext(vehicle -> assertEquals("3333", vehicle.getRegNr()))
                        .expectComplete()
                        .verify();
            });
        });


    }
}