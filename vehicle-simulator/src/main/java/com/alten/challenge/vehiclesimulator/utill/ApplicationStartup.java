package com.alten.challenge.vehiclesimulator.utill;

import com.alten.challenge.vehiclesimulator.constants.PropertiesKey;
import com.alten.challenge.vehiclesimulator.model.Customer;
import com.alten.challenge.vehiclesimulator.model.Vehicle;
import com.alten.challenge.vehiclesimulator.repository.CustomersRepository;
import com.alten.challenge.vehiclesimulator.repository.VehiclesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationStartup
        implements ApplicationRunner {
    private final CustomersRepository customersRepository;
    private final VehiclesRepository vehiclesRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(customersRepository.findByFullName(PropertiesKey.Kalles_Grustransporte).block()==null){
            customersRepository.save(Customer.builder()
                    .fullName(PropertiesKey.Kalles_Grustransporte).address(PropertiesKey.Kalles_Address).build()).subscribe(customer -> {
                vehiclesRepository.saveAll(
                        List.of(
                                Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Kalles_Vin1).regNr(PropertiesKey.Kalles_RegNr1).build(),
                                Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Kalles_Vin2).regNr(PropertiesKey.Kalles_RegNr2).build(),
                                Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Kalles_Vin3).regNr(PropertiesKey.Kalles_RegNr3).build()
                        )).subscribe();
            });

        }
        if(customersRepository.findByFullName(PropertiesKey.Johans_Bulk).block()==null){
            customersRepository.save(Customer.builder().fullName(PropertiesKey.Johans_Bulk).address(PropertiesKey.Johans_Address).build()).subscribe(customer -> {
                vehiclesRepository.saveAll(
                        List.of(
                                Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Johans_Vin1).regNr(PropertiesKey.Johans_RegNr1).build(),
                                Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Johans_Vin2).regNr(PropertiesKey.Johans_RegNr2).build()
                        )).subscribe();
            });
        }
        if(customersRepository.findByFullName(PropertiesKey.Haralds_Värdetransporter).block()==null){
            customersRepository.save(Customer.builder()
                    .fullName(PropertiesKey.Haralds_Värdetransporter).address(PropertiesKey.Haralds_Address).build()).subscribe(customer -> {
                vehiclesRepository.saveAll(
                        List.of(
                                Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Haralds_Vin1).regNr(PropertiesKey.Haralds_RegNr1).build(),
                                Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Haralds_Vin2).regNr(PropertiesKey.Haralds_RegNr2).build()
                        )).subscribe();
            });
        }
    }
}