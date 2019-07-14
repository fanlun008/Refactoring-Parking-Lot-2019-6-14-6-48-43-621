package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StorythreeTest {


    @Test
    public void AC1_packingboy_can_park_car_to_more_parkingLot() {
        Park park = new Park();
        Park park1 = new Park();
        List<Park> parkList = Arrays.asList(park, park1);
        ParkingBoy parkingBoy = new ParkingBoy(parkList);
        for (int i = 0; i < 10; i++){
            Customer john = new Customer("John"+i, new Car("John's car"+i));
            parkingBoy.servePark(john);
        }
        Customer bill = new Customer("Bill", new Car("Bill's car"));
        Ticket ticket = parkingBoy.servePark(bill);
        Assertions.assertEquals(1, park1.getCarList().size());
    }

}
