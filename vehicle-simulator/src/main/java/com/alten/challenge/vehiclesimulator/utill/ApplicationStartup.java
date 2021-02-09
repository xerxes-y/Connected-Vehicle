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
    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        if(customersRepository.findByFullName(PropertiesKey.Kalles_Grustransporte).block()==null){
            customersRepository.save(Customer.builder()
                    .fullName(PropertiesKey.Kalles_Grustransporte).address(PropertiesKey.Kalles_Address).build()).subscribe(customer -> {
                List<Vehicle> kallesVehicle = new ArrayList<>();
                kallesVehicle.add(Vehicle.builder().customerId(customer.getId()).regNr(PropertiesKey.Kalles_RegNr1).vin(PropertiesKey.Kalles_Vin1).build());
                kallesVehicle.add(Vehicle.builder().customerId(customer.getId()).regNr(PropertiesKey.Kalles_RegNr2).vin(PropertiesKey.Kalles_Vin2).build());
                kallesVehicle.add(Vehicle.builder().customerId(customer.getId()).regNr(PropertiesKey.Kalles_RegNr3).vin(PropertiesKey.Kalles_Vin3).build());
                vehiclesRepository.saveAll(kallesVehicle).subscribe();
            });

        }
        if(customersRepository.findByFullName(PropertiesKey.Johans_Bulk).block()==null){
            customersRepository.save(Customer.builder().fullName(PropertiesKey.Johans_Bulk).address(PropertiesKey.Johans_Address).build()).subscribe(customer -> {
                List<Vehicle> johansVehicle = new ArrayList<>();
                johansVehicle.add(Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Johans_RegNr1).regNr(PropertiesKey.Johans_Vin1).build());
                johansVehicle.add(Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Johans_RegNr1).regNr(PropertiesKey.Johans_Vin2).build());
                vehiclesRepository.saveAll(johansVehicle).subscribe();
            });
        }
        if(customersRepository.findByFullName(PropertiesKey.Haralds_Värdetransporter).block()==null){
            customersRepository.save(Customer.builder()
                    .fullName(PropertiesKey.Haralds_Värdetransporter).address(PropertiesKey.Haralds_Address).build()).subscribe(customer -> {
                List<Vehicle> haraldsVehicle = new ArrayList<>();
                haraldsVehicle.add(Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Haralds_Vin1).regNr(PropertiesKey.Haralds_RegNr1).build());
                haraldsVehicle.add(Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Haralds_Vin2).regNr(PropertiesKey.Haralds_RegNr2).build());
                vehiclesRepository.saveAll(haraldsVehicle).subscribe();

            });
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(customersRepository.findByFullName(PropertiesKey.Kalles_Grustransporte).block()==null){
            customersRepository.save(Customer.builder()
                    .fullName(PropertiesKey.Kalles_Grustransporte).address(PropertiesKey.Kalles_Address).build()).subscribe(customer -> {
                List<Vehicle> kallesVehicle = new ArrayList<>();
                kallesVehicle.add(Vehicle.builder().customerId(customer.getId()).regNr(PropertiesKey.Kalles_RegNr1).vin(PropertiesKey.Kalles_Vin1).build());
                kallesVehicle.add(Vehicle.builder().customerId(customer.getId()).regNr(PropertiesKey.Kalles_RegNr2).vin(PropertiesKey.Kalles_Vin2).build());
                kallesVehicle.add(Vehicle.builder().customerId(customer.getId()).regNr(PropertiesKey.Kalles_RegNr3).vin(PropertiesKey.Kalles_Vin3).build());
                vehiclesRepository.saveAll(kallesVehicle).subscribe();
            });

        }
        if(customersRepository.findByFullName(PropertiesKey.Johans_Bulk).block()==null){
            customersRepository.save(Customer.builder().fullName(PropertiesKey.Johans_Bulk).address(PropertiesKey.Johans_Address).build()).subscribe(customer -> {
                List<Vehicle> johansVehicle = new ArrayList<>();
                johansVehicle.add(Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Johans_RegNr1).regNr(PropertiesKey.Johans_Vin1).build());
                johansVehicle.add(Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Johans_RegNr1).regNr(PropertiesKey.Johans_Vin2).build());
                vehiclesRepository.saveAll(johansVehicle).subscribe();
            });
        }
        if(customersRepository.findByFullName(PropertiesKey.Haralds_Värdetransporter).block()==null){
            customersRepository.save(Customer.builder()
                    .fullName(PropertiesKey.Haralds_Värdetransporter).address(PropertiesKey.Haralds_Address).build()).subscribe(customer -> {
                List<Vehicle> haraldsVehicle = new ArrayList<>();
                haraldsVehicle.add(Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Haralds_Vin1).regNr(PropertiesKey.Haralds_RegNr1).build());
                haraldsVehicle.add(Vehicle.builder().customerId(customer.getId()).vin(PropertiesKey.Haralds_Vin2).regNr(PropertiesKey.Haralds_RegNr2).build());
                vehiclesRepository.saveAll(haraldsVehicle).subscribe();

            });
        }
    }
}