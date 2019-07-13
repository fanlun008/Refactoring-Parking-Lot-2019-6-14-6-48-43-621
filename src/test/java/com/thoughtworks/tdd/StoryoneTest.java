package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoryoneTest {

    @Test
    public void AC1_should_getPicket_when_giveCar() {
        Car car = new Car();
        Customer customer = new Customer(car);
        Park park = new Park();
        ParkingBoy parkingBoy = new ParkingBoy(park);
        Ticket ticket = parkingBoy.servePark(customer);
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void AC1_should_getCar_when_giveTicket(){
        Car car = new Car();
        Customer customer = new Customer(car);
        Park park = new Park();
        ParkingBoy parkingBoy = new ParkingBoy(park);
        Car pickCar = parkingBoy.servePick(customer);

        Assertions.assertNotNull(pickCar);
    }

    @Test
    public void AC1_park_should_have_car_when_boy_parkCar() {
        Car car = new Car();
        Customer customer = new Customer(car);
        Park park = new Park();
        ParkingBoy parkingBoy = new ParkingBoy(park);
        Ticket ticket = parkingBoy.servePark(customer);
        Assertions.assertEquals(park.getCarList().size(), 1);
    }


    @Test
    public void test01() {
        Ticket ticket = new Ticket();
        ticket.setValid(true);

    }
}
