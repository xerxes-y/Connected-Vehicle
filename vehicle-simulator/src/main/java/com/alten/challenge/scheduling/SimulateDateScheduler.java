package com.alten.challenge.scheduling;

import com.alten.challenge.dto.VehicleStatus;
import com.alten.challenge.model.Customer;
import com.alten.challenge.model.Vehicle;
import com.alten.challenge.repository.CustomersRepository;
import com.alten.challenge.repository.VehiclesRepository;
import com.alten.challenge.stream.StreamMessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class SimulateDateScheduler {
    private final VehiclesRepository vehiclesRepository;
    private final CustomersRepository customersRepository;
    private final StreamMessageSender streamMessageSender;

    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator1(){
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal,8,30,0);
        Date endTime = getDate(cal,10,30,0);
        Date afternoonTime = getDate(cal,17,30,0);
        Date endAfternoonTime = getDate(cal,19,30,0);
        if(date.after(startTime)&&date.before(endTime)||date.after(afternoonTime)&&date.before(endAfternoonTime)){
            Customer kallesDriver = customersRepository.findByFullName("Kalles Grustransporte").block();
            Vehicle vehicle = vehiclesRepository.findByVinAndAvailability("YS2R4X20005399401", true).block();
            Random rand = new Random();
            VehicleStatus vehicleStatus = new VehicleStatus(vehicle.getVin(),kallesDriver.getId(),
                    1,true, rand.nextInt(10 - 1 + 1) + 1);
            streamMessageSender.sentMessage(vehicleStatus);
        }
    }
    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator2(){
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal,12,30,0);
        Date endTime = getDate(cal,14,30,0);
        Date afternoonTime = getDate(cal,15,30,0);
        Date endAfternoonTime = getDate(cal,17,30,0);
        if(date.after(startTime)&&date.before(endTime)||date.after(afternoonTime)&&date.before(endAfternoonTime)){
            Customer kallesDriver = customersRepository.findByFullName("Kalles Grustransporte").block();
            Vehicle vehicle = vehiclesRepository.findByVinAndAvailability("VLUR4X20009093588", true).block();
            Random rand = new Random();
            VehicleStatus vehicleStatus = new VehicleStatus(vehicle.getVin(),kallesDriver.getId(),
                    2,true, rand.nextInt(10 - 1 + 1) + 1);
            streamMessageSender.sentMessage(vehicleStatus);
        }
    }
    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator3(){
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal,9,30,0);
        Date endTime = getDate(cal,15,30,0);
        Date afternoonTime = getDate(cal,20,30,0);
        Date endAfternoonTime = getDate(cal,23,30,0);
        if(date.after(startTime)&&date.before(endTime)||date.after(afternoonTime)&&date.before(endAfternoonTime)){
            Customer kallesDriver = customersRepository.findByFullName("Kalles Grustransporte").block();
            Vehicle vehicle = vehiclesRepository.findByVinAndAvailability("VLUR4X20009048066", true).block();
            Random rand = new Random();
            VehicleStatus vehicleStatus = new VehicleStatus(vehicle.getVin(),kallesDriver.getId(),
                    3,true, rand.nextInt(10 - 1 + 1) + 1);
            streamMessageSender.sentMessage(vehicleStatus);
        }
    }
    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator4(){
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal,4,30,0);
        Date endTime = getDate(cal,8,30,0);
        Date afternoonTime = getDate(cal,12,30,0);
        Date endAfternoonTime = getDate(cal,16,30,0);
        if(date.after(startTime)&&date.before(endTime)||date.after(afternoonTime)&&date.before(endAfternoonTime)){
            Customer kallesDriver = customersRepository.findByFullName("Johans Bulk").block();
            Vehicle vehicle = vehiclesRepository.findByVinAndAvailability("YS2R4X20005388011", true).block();
            Random rand = new Random();
            VehicleStatus vehicleStatus = new VehicleStatus(vehicle.getVin(),kallesDriver.getId(),
                    4,true, rand.nextInt(10 - 1 + 1) + 1);
            streamMessageSender.sentMessage(vehicleStatus);
        }
    }
    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator5(){
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal,2,30,0);
        Date endTime = getDate(cal,8,30,0);
        Date afternoonTime = getDate(cal,13,30,0);
        Date endAfternoonTime = getDate(cal,17,30,0);
        if(date.after(startTime)&&date.before(endTime)||date.after(afternoonTime)&&date.before(endAfternoonTime)){
            Customer kallesDriver = customersRepository.findByFullName("Johans Bulk").block();
            Vehicle vehicle = vehiclesRepository.findByVinAndAvailability("YS2R4X20005387949", true).block();
            Random rand = new Random();
            VehicleStatus vehicleStatus = new VehicleStatus(vehicle.getVin(),kallesDriver.getId(),
                    5,true, rand.nextInt(10 - 1 + 1) + 1);
            streamMessageSender.sentMessage(vehicleStatus);
        }
    }
    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator6(){
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal,1,30,0);
        Date endTime = getDate(cal,7,30,0);
        Date afternoonTime = getDate(cal,18,30,0);
        Date endAfternoonTime = getDate(cal,22,30,0);
        if(date.after(startTime)&&date.before(endTime)||date.after(afternoonTime)&&date.before(endAfternoonTime)){
            Customer kallesDriver = customersRepository.findByFullName("Haralds Värdetransporter").block();
            Vehicle vehicle = vehiclesRepository.findByVinAndAvailability("YS2R4X20005387765", true).block();
            Random rand = new Random();
            VehicleStatus vehicleStatus = new VehicleStatus(vehicle.getVin(),kallesDriver.getId(),
                    6,true, rand.nextInt(10 - 1 + 1) + 1);
            streamMessageSender.sentMessage(vehicleStatus);
        }
    }
    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator7(){
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal,3,30,0);
        Date endTime = getDate(cal,5,30,0);
        Date afternoonTime = getDate(cal,8,30,0);
        Date endAfternoonTime = getDate(cal,12,30,0);
        if(date.after(startTime)&&date.before(endTime)||date.after(afternoonTime)&&date.before(endAfternoonTime)){
            Customer kallesDriver = customersRepository.findByFullName("Haralds Värdetransporter").block();
            Vehicle vehicle = vehiclesRepository.findByVinAndAvailability("YS2R4X20005399401", true).block();
            Random rand = new Random();
            VehicleStatus vehicleStatus = new VehicleStatus(vehicle.getVin(),kallesDriver.getId(),
                    7,true, rand.nextInt(10 - 1 + 1) + 1);
            streamMessageSender.sentMessage(vehicleStatus);
        }
    }
    private Date getDate(Calendar calendar,int hour,int minute,int second){
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);
        return calendar.getTime();

    }
}
