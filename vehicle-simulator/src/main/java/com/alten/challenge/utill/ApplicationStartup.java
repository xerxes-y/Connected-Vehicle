package com.alten.challenge.utill;

import com.alten.challenge.model.Customer;
import com.alten.challenge.model.Vehicle;
import com.alten.challenge.repository.CustomersRepository;
import com.alten.challenge.repository.VehiclesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationStartup
        implements ApplicationListener<ApplicationReadyEvent> {
    private final CustomersRepository customersRepository;
    private final VehiclesRepository vehiclesRepository;
    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        if(customersRepository.findByFullName("Kalles Grustransporte").block()==null){
            Customer kallesGrustransporte  = new Customer();
            kallesGrustransporte.setAddress("Cementvägen 8, 111 11 Södertälje");
            kallesGrustransporte.setFullName("Kalles Grustransporte");
            customersRepository.save(kallesGrustransporte).subscribe(customer -> {
                List<Vehicle> kallesVehicle = new ArrayList<>();
                Vehicle kv1 = new Vehicle();
                kv1.setRegNr("ABC123");
                kv1.setVin("YS2R4X20005399401");
                kv1.setCustomerId(customer.getId());
                Vehicle kv2 = new Vehicle();
                kv2.setRegNr("DEF456");
                kv2.setVin("VLUR4X20009093588");
                kv2.setCustomerId(customer.getId());
                Vehicle kv3 = new Vehicle();
                kv3.setRegNr("GHI789");
                kv3.setVin("VLUR4X20009048066");
                kv3.setCustomerId(customer.getId());
                kallesVehicle.add(kv1);
                kallesVehicle.add(kv2);
                kallesVehicle.add(kv3);
                vehiclesRepository.saveAll(kallesVehicle).subscribe();
            });

        }
        if(customersRepository.findByFullName("Johans Bulk").block()==null){
            Customer johans = new Customer();
            johans.setFullName("Johans Bulk");
            johans.setAddress("alkvägen 12, 222 22 Stockholm");
            customersRepository.save(johans).subscribe(customer -> {
                List<Vehicle> johansVehicle = new ArrayList<>();
                Vehicle jv1 = new Vehicle();
                jv1.setRegNr("JKL012");
                jv1.setVin("YS2R4X20005388011");
                jv1.setCustomerId(customer.getId());
                Vehicle jv2 = new Vehicle();
                jv2.setRegNr("MNO345");
                jv2.setVin("YS2R4X20005387949");
                jv2.setCustomerId(customer.getId());
                johansVehicle.add(jv1);
                johansVehicle.add(jv2);
                vehiclesRepository.saveAll(johansVehicle).subscribe();
            });
        }
        if(customersRepository.findByFullName("Johans Bulk").block()==null){
            Customer haralds = new Customer();
            haralds.setAddress("Budgetvägen 1, 333 33 Uppsala");
            haralds.setFullName("Haralds Värdetransporter");
            customersRepository.save(haralds).subscribe(customer -> {
                List<Vehicle> haraldsVehicle = new ArrayList<>();
                Vehicle hv1 = new Vehicle();
                hv1.setRegNr("PQR678");
                hv1.setVin("YS2R4X20005387765");
                hv1.setCustomerId(customer.getId());
                Vehicle hv2 = new Vehicle();
                hv2.setRegNr("STU901");
                hv2.setVin("YS2R4X20005387055");
                hv2.setCustomerId(customer.getId());
                haraldsVehicle.add(hv1);
                haraldsVehicle.add(hv2);
                vehiclesRepository.saveAll(haraldsVehicle).subscribe();

            });
        }
        return;
    }
}