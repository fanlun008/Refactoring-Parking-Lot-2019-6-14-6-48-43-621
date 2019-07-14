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
//        Car car = new Car("onepunch");
//        Customer customer = new Customer(car);
//        Park park = new Park();
//        ParkingBoy parkingBoy = new ParkingBoy(park);
//        Ticket oneTicket = new Ticket();
//        customer.setTicket(oneTicket);
//        Car pickCar = parkingBoy.servePick(customer);

        Ticket ticket = new Ticket("AAA", "carId", true);
        Park park = new Park();
        park.getCarList().put("AAA", new Car());
        ParkingBoy parkingBoy = new ParkingBoy(park);
        Car car = parkingBoy.pickByTicket(ticket);

        Assertions.assertNotNull(car);
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
    public void AC2_boy_can_park_more_car_to_Park() {
        Customer john = new Customer("John", new Car("John's car"));
        Customer Andy = new Customer("Andy", new Car("Andy's car"));
        Customer Bill = new Customer("Bill", new Car("Bill's car"));
        Park park = new Park();
        ParkingBoy parkingBoy = new ParkingBoy(park);
        parkingBoy.servePark(john);
        parkingBoy.servePark(Andy);
        parkingBoy.servePark(Bill);
        Assertions.assertEquals(park.getCarList().size(), 3);
    }

    @Test
    public void AC2_can_take_correctCar_By_Ticket() {
        Customer john = new Customer("John", new Car("John's car"));
        Customer Andy = new Customer("Andy", new Car("Andy's car"));
        Customer Bill = new Customer("Bill", new Car("Bill's car"));
        Park park = new Park();
        ParkingBoy parkingBoy = new ParkingBoy(park);
        Ticket ticket = parkingBoy.servePark(john);
        Ticket ticket1 = parkingBoy.servePark(Andy);
        Ticket ticket2 = parkingBoy.servePark(Bill);

        Car car = parkingBoy.pickByTicket(ticket);
        Assertions.assertEquals(car, john.getCar());
    }

    @Test
    public void AC3_can_not_getCar_when_provide_error_ticket(){
        Customer john = new Customer("John", new Car("John's car"));
        Park park = new Park();
        ParkingBoy parkingBoy = new ParkingBoy(park);
        Ticket ticket = parkingBoy.servePark(john);
        ticket.setTicketId("FFF");
        Assertions.assertNull(parkingBoy.servePick(john));
    }

    @Test
    public void AC4_can_not_getCar_when_provide_outdate_ticket(){
        Customer john = new Customer("John", new Car("John's car"));
        Park park = new Park();
        ParkingBoy parkingBoy = new ParkingBoy(park);
        Ticket ticket = parkingBoy.servePark(john);
        Car firstTimeCar = parkingBoy.servePick(john);
        Car secondTimerCar = parkingBoy.servePick(john);
        Assertions.assertNotNull(firstTimeCar);
        Assertions.assertNull(secondTimerCar);
    }

    @Test
    public void AC5_cannot_getTicket_if_park_no_size(){
        Park park = new Park();
        ParkingBoy parkingBoy = new ParkingBoy(park);
        for (int i = 0; i < 10; i++){
            Customer john = new Customer("John"+i, new Car("John's car"+i));
            parkingBoy.servePark(john);
        }

        Customer bill = new Customer("John", new Car("John's car"));
        Ticket ticket = parkingBoy.servePark(bill);

        Assertions.assertNull(ticket);
    }

    @Test
    public void test01() {
        Ticket ticket = new Ticket();
        ticket.setValid(true);

    }
}
