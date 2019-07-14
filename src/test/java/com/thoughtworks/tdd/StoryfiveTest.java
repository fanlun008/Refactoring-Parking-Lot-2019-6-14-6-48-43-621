package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StoryfiveTest {
    @Test
    public void AC1_smallBoy_should_parkCar_to_park1_when_park1_have_more_free_percentage() {
        Park park1 = new Park(20);
        Park park2 = new Park(9);
        List<Park> parkList = Arrays.asList(park1, park2);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(parkList);
        for (int i = 0; i < 19; i++) {
            Customer john = new Customer("John" + i, new Car("John's car" + i));
            parkingBoy.servePark(john);
        }
        Customer bill = new Customer("Bill", new Car("Bill's car"));
        Ticket ticket = parkingBoy.servePark(bill);
        Assertions.assertEquals(bill.getCar(), park1.getCarList().get(ticket.getTicketId()));
    }
}
