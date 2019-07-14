package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StorytwoTest {

    @Test
    public void AC1_should_get_unrecognized_when_give_invalid_ticket() {
        Ticket ticket = new Ticket("6f8sx", "A's Car", true);
        Customer A = new Customer().setTicket(ticket);
        ParkingBoy parkingBoy = new ParkingBoy(new Park());
        parkingBoy.servePick(A);
        Assertions.assertEquals("Unrecognized parking ticket.", A.getServerMsg());
    }

    @Test
    public void AC2_should_get_provideTicketMsg_when_give_null_ticket() {
        Park park = new Park();
        ParkingBoy parkingBoy = new ParkingBoy(park);
        Customer A = new Customer();
        parkingBoy.servePick(A);
        Assertions.assertEquals("Please provide your parking ticket.", A.getServerMsg());
    }

    @Test
    public void AC2_should_get_FULLSize_when_giveCar_to_FullPark(){
        Park park = new Park();
        ParkingBoy parkingBoy = new ParkingBoy(park);
        for (int i = 0; i < 10; i++){
            Customer john = new Customer("John"+i, new Car("John's car"+i));
            parkingBoy.servePark(john);
        }
        Customer bill = new Customer("John", new Car("John's car"));
        Ticket ticket = parkingBoy.servePark(bill);
        Assertions.assertEquals("Not enough position.", bill.getServerMsg());
    }

}
