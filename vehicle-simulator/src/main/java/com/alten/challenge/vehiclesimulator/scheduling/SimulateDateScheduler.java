package com.alten.challenge.vehiclesimulator.scheduling;

import com.alten.challenge.vehiclesimulator.constants.PropertiesKey;
import com.alten.challenge.vehiclesimulator.dto.StatusDetailSender;
import com.alten.challenge.vehiclesimulator.dto.VehicleStatusSenderDto;
import com.alten.challenge.vehiclesimulator.repository.CustomersRepository;
import com.alten.challenge.vehiclesimulator.repository.VehiclesRepository;
import com.alten.challenge.vehiclesimulator.stream.StreamMessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
@Slf4j
public class SimulateDateScheduler {
    private final VehiclesRepository vehiclesRepository;
    private final CustomersRepository customersRepository;
    private final StreamMessageSender streamMessageSender;

    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator1() {
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal, 8, 30, 0);
        Date endTime = getDate(cal, 2, 30, 0);
        Date afternoonTime = getDate(cal, 17, 30, 0);
        Date endAfternoonTime = getDate(cal, 19, 30, 0);
        if (date.after(startTime) && date.before(endTime) || date.after(afternoonTime) && date.before(endAfternoonTime)) {
           customersRepository.findByFullName(PropertiesKey.Kalles_Grustransporte).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Kalles_Vin1, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(true);
                    statusDetail.setGas(120);
                    statusDetail.setRunEngine(true);
                    statusDetail.setSpeedKilometers(ThreadLocalRandom.current().nextInt(11, 120 + 1));
                    statusDetail.setOpenDoor(false);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            1, true, ThreadLocalRandom.current().nextInt(2, 10+ 1), statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });
        }else {
            customersRepository.findByFullName(PropertiesKey.Kalles_Grustransporte).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Kalles_Vin1, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(false);
                    statusDetail.setGas(120);
                    statusDetail.setRunEngine(false);
                    statusDetail.setSpeedKilometers(0);
                    statusDetail.setOpenDoor(false);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            1, true, 0, statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });
        }
    }

    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator2() {
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal, 12, 30, 0);
        Date endTime = getDate(cal, 14, 30, 0);
        Date afternoonTime = getDate(cal, 15, 30, 0);
        Date endAfternoonTime = getDate(cal, 17, 30, 0);
        if (date.after(startTime) && date.before(endTime) || date.after(afternoonTime) && date.before(endAfternoonTime)) {
            customersRepository.findByFullName(PropertiesKey.Kalles_Grustransporte).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Kalles_Vin2, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(true);
                    statusDetail.setGas(120);
                    statusDetail.setRunEngine(true);
                    statusDetail.setSpeedKilometers(ThreadLocalRandom.current().nextInt(11, 120 + 1));
                    statusDetail.setOpenDoor(false);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            1, true, ThreadLocalRandom.current().nextInt(2, 10+ 1), statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });

        } else {
            customersRepository.findByFullName(PropertiesKey.Kalles_Grustransporte).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Kalles_Vin2, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(false);
                    statusDetail.setGas(120);
                    statusDetail.setRunEngine(false);
                    statusDetail.setSpeedKilometers(0);
                    statusDetail.setOpenDoor(false);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            1, true, 0, statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });
        }
    }

    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator3() {
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal, 9, 30, 0);
        Date endTime = getDate(cal, 15, 30, 0);
        Date afternoonTime = getDate(cal, 120, 30, 0);
        Date endAfternoonTime = getDate(cal, 23, 30, 0);
        if (date.after(startTime) && date.before(endTime) || date.after(afternoonTime) && date.before(endAfternoonTime)) {
            customersRepository.findByFullName(PropertiesKey.Kalles_Grustransporte).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Kalles_Vin3, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(true);
                    statusDetail.setGas(40);
                    statusDetail.setRunEngine(true);
                    statusDetail.setSpeedKilometers(ThreadLocalRandom.current().nextInt(11, 120 + 1));
                    statusDetail.setOpenDoor(true);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            3, true, ThreadLocalRandom.current().nextInt(2, 10+ 1), statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });

        } else {
            customersRepository.findByFullName(PropertiesKey.Kalles_Grustransporte).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Kalles_Vin3, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(false);
                    statusDetail.setGas(120);
                    statusDetail.setRunEngine(false);
                    statusDetail.setSpeedKilometers(0);
                    statusDetail.setOpenDoor(false);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            3, true, 0, statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });
        }
    }

    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator4() {
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal, 4, 30, 0);
        Date endTime = getDate(cal, 8, 30, 0);
        Date afternoonTime = getDate(cal, 12, 30, 0);
        Date endAfternoonTime = getDate(cal, 16, 30, 0);
        if (date.after(startTime) && date.before(endTime) || date.after(afternoonTime) && date.before(endAfternoonTime)) {
            customersRepository.findByFullName(PropertiesKey.Johans_Bulk).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Johans_Vin1, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(true);
                    statusDetail.setGas(40);
                    statusDetail.setRunEngine(true);
                    statusDetail.setSpeedKilometers(ThreadLocalRandom.current().nextInt(11, 120 + 1));
                    statusDetail.setOpenDoor(true);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            2, true, ThreadLocalRandom.current().nextInt(2, 10+ 1), statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });

        } else {
            customersRepository.findByFullName(PropertiesKey.Johans_Bulk).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Johans_Vin1, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(false);
                    statusDetail.setGas(120);
                    statusDetail.setRunEngine(false);
                    statusDetail.setSpeedKilometers(0);
                    statusDetail.setOpenDoor(false);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            2, true, 0, statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });
        }
    }

    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator5() {
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal, 2, 30, 0);
        Date endTime = getDate(cal, 8, 30, 0);
        Date afternoonTime = getDate(cal, 13, 30, 0);
        Date endAfternoonTime = getDate(cal, 17, 30, 0);
        if (date.after(startTime) && date.before(endTime) || date.after(afternoonTime) && date.before(endAfternoonTime)) {
            customersRepository.findByFullName(PropertiesKey.Johans_Bulk).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Johans_Vin2, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(true);
                    statusDetail.setGas(40);
                    statusDetail.setRunEngine(true);
                    statusDetail.setSpeedKilometers(ThreadLocalRandom.current().nextInt(11, 120 + 1));
                    statusDetail.setOpenDoor(true);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            5, true, ThreadLocalRandom.current().nextInt(2, 10+ 1), statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });

        } else {
            customersRepository.findByFullName(PropertiesKey.Johans_Bulk).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Johans_Vin2, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(false);
                    statusDetail.setGas(120);
                    statusDetail.setRunEngine(false);
                    statusDetail.setSpeedKilometers(0);
                    statusDetail.setOpenDoor(false);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            5, true, 0, statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });
        }
    }

    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator6() {
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal, 1, 30, 0);
        Date endTime = getDate(cal, 7, 30, 0);
        Date afternoonTime = getDate(cal, 18, 30, 0);
        Date endAfternoonTime = getDate(cal, 22, 30, 0);
        if (date.after(startTime) && date.before(endTime) || date.after(afternoonTime) && date.before(endAfternoonTime)) {
            customersRepository.findByFullName(PropertiesKey.Haralds_Värdetransporter).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Haralds_Vin1, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(true);
                    statusDetail.setGas(40);
                    statusDetail.setRunEngine(true);
                    statusDetail.setSpeedKilometers(ThreadLocalRandom.current().nextInt(11, 120 + 1));
                    statusDetail.setOpenDoor(true);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            6, true, ThreadLocalRandom.current().nextInt(2, 10+ 1), statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });

        } else {
            customersRepository.findByFullName(PropertiesKey.Haralds_Värdetransporter).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Haralds_Vin1, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(false);
                    statusDetail.setGas(120);
                    statusDetail.setRunEngine(false);
                    statusDetail.setSpeedKilometers(0);
                    statusDetail.setOpenDoor(false);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            6, true, 0, statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });
        }
    }

    @Scheduled(fixedRate = 60000)
    public void driverDataGenerator7() {
        Date date = new Date();// given date
        Calendar cal = Calendar.getInstance(); // creates calendar
        Date startTime = getDate(cal, 3, 30, 0);
        Date endTime = getDate(cal, 5, 30, 0);
        Date afternoonTime = getDate(cal, 8, 30, 0);
        Date endAfternoonTime = getDate(cal, 12, 30, 0);
        if (date.after(startTime) && date.before(endTime) || date.after(afternoonTime) && date.before(endAfternoonTime)) {
            customersRepository.findByFullName(PropertiesKey.Haralds_Värdetransporter).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Haralds_Vin2, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(true);
                    statusDetail.setGas(40);
                    statusDetail.setRunEngine(true);
                    statusDetail.setSpeedKilometers(ThreadLocalRandom.current().nextInt(11, 120 + 1));
                    statusDetail.setOpenDoor(true);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            7, true, ThreadLocalRandom.current().nextInt(2, 10+ 1), statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });

        } else {
            customersRepository.findByFullName(PropertiesKey.Haralds_Värdetransporter).subscribe(customer -> {
                vehiclesRepository.findByVinAndCustomerId(PropertiesKey.Haralds_Vin2, customer.getId()).subscribe(vehicle -> {
                    StatusDetailSender statusDetail = new StatusDetailSender();
                    statusDetail.setConnected(false);
                    statusDetail.setGas(120);
                    statusDetail.setRunEngine(false);
                    statusDetail.setSpeedKilometers(0);
                    statusDetail.setOpenDoor(false);
                    VehicleStatusSenderDto vehicleStatus = new VehicleStatusSenderDto(vehicle.getVin(), customer.getId(),
                            7, true, 0, statusDetail);
                    streamMessageSender.sentMessage(vehicleStatus);
                });
            });
        }
    }

    private Date getDate(Calendar calendar, int hour, int minute, int second) {
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();

    }
}
