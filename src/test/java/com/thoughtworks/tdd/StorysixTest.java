package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StorysixTest {


    @Test
    public void AC1_manager_can_add_Boy() {
        ParkingBoy parkingBoy1 = new ParkingBoy("John_PackingBoy");
        Manager manager = new Manager("Bill_Manager");
        manager.addParkBoy(parkingBoy1).addParkBoy(new ParkingBoy())
                .addParkBoy(parkingBoy1).addParkBoy(new ParkingBoy());
        Assertions.assertEquals(3, manager.getParkingBoyList().size());
    }

    @Test
    public void AC1_manager_call_parkBoy_to_park() {
        Park park1 = new Park();
        Park park2 = new Park();
        ParkingBoy parkingBoy1 = new ParkingBoy("parkingBoy_001", Arrays.asList(park2));
        SmartParkingBoy parkingBoy2 = new SmartParkingBoy("parkingBoy_002",Arrays.asList(park1));
        Customer customer = new Customer("Customer_John", new Car());
        Manager manager = new Manager().addParkBoy(parkingBoy1).addParkBoy(parkingBoy2);
        manager.callParkBoyToPark("parkingBoy_001", customer);

        Assertions.assertEquals(customer.getCar(), park2.getCarList().get(customer.getTicket().getTicketId()));
    }

    @Test
    public void AC1_manager_cannot_call_parkBoy_no_in_his_manage() {
        Park park1 = new Park();
        Park park2 = new Park();
        ParkingBoy parkingBoy1 = new ParkingBoy("parkingBoy_001", Arrays.asList(park2));
        SmartParkingBoy parkingBoy2 = new SmartParkingBoy("parkingBoy_002",Arrays.asList(park1));
        Customer customer = new Customer("Customer_John", new Car());
        Manager manager = new Manager().addParkBoy(parkingBoy1).addParkBoy(parkingBoy2);
        manager.callParkBoyToPark("parkingBoy_0001", customer);

        Assertions.assertEquals("I have no this parkingBoy - parkingBoy_0001", manager.getServeMsg());
    }

    @Test
    public void Ac1_manager_call_parkBoy_to_pick() {
        Park park1 = new Park();
        Park park2 = new Park();
        ParkingBoy parkingBoy1 = new ParkingBoy("parkingBoy_001", Arrays.asList(park2));
        SmartParkingBoy parkingBoy2 = new SmartParkingBoy("parkingBoy_002",Arrays.asList(park1));
        Customer customer = new Customer("Customer_John", new Car());
        Manager manager = new Manager().addParkBoy(parkingBoy1).addParkBoy(parkingBoy2);
        manager.callParkBoyToPark("parkingBoy_001", customer);
        manager.callParkBoyToPick("parkingBoy_002", customer);
        Assertions.assertEquals("Unrecognized parking ticket.", manager.getServeMsg());
    }

    @Test
    public void AC2_manager_can_dothings_like_simple_parkingBoy(){
        Park park1 = new Park();
        Park park2 = new Park();
        Manager manager = new Manager();
        manager.setParkList(Arrays.asList(park1, park2));
        Car car = new Car();
        Customer customer = new Customer("Customer_001", car);
        Ticket ticket = manager.servePark(customer);
        Assertions.assertEquals(car, park1.getCarList().get(ticket.getTicketId()));

        Car car1 = manager.servePick(customer);
        Assertions.assertEquals(car, car1);
    }

    @Test
    public void AC3_parkingBoy_should_logOut_message_when_he_cannot_doTask() {
        Park park1 = new Park();
        Park park2 = new Park();
        ParkingBoy parkingBoy1 = new ParkingBoy("parkingBoy_001", Arrays.asList(park2));
        SmartParkingBoy parkingBoy2 = new SmartParkingBoy("parkingBoy_002",Arrays.asList(park1));
        Customer customer = new Customer("Customer_John", new Car());
        Manager manager = new Manager().addParkBoy(parkingBoy1).addParkBoy(parkingBoy2);
        manager.callParkBoyToPark("parkingBoy_001", customer);
        manager.callParkBoyToPick("parkingBoy_002", customer);
        Assertions.assertEquals("Unrecognized parking ticket.", manager.getServeMsg());
    }
}
