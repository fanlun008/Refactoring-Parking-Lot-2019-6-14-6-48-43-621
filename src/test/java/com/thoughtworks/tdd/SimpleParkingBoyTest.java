package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SimpleParkingBoyTest {
    @Test
    public void test() {
        Car car = new Car();
        Customer customer = new Customer(car);
        Park park = new Park();
        ParkingAttendant parkingBoy = new SimpleParkingBoy(Arrays.asList(park));
        Ticket ticket = parkingBoy.servePark(customer);
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void test_smartParkingBoy_R_work () {
        Park park1 = new Park(100);
        Park park2 = new Park(9);
        List<Park> parkList = Arrays.asList(park1, park2);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkList);
        for (int i = 0; i < 19; i++){
            Customer john = new Customer("John"+i, new Car("John's car"+i));
            parkingBoy.servePark(john);
        }
        Customer bill = new Customer("Bill", new Car("Bill's car"));
        Ticket ticket = parkingBoy.servePark(bill);
        Assertions.assertEquals(bill.getCar(), park1.getCarList().get(ticket.getTicketId()));
    }

    @Test
    public void test_simplePBoy_parkByOrder() {
        Park park = new Park(5);
        Park park1 = new Park(3);
        Park park2 = new Park(7);
        List<Park> parkList = Arrays.asList(park, park1, park2);
        ParkingAttendant parkingBoy = new SimpleParkingBoy(parkList);
        for (int i = 0; i < 10; i++){
            Customer john = new Customer("John"+i, new Car("John's car"+i));
            parkingBoy.servePark(john);
        }
        Customer bill = new Customer("Bill", new Car("Bill's car"));
        Ticket ticket = parkingBoy.servePark(bill);
        Assertions.assertEquals(3, park2.getCarList().size());
    }
}
