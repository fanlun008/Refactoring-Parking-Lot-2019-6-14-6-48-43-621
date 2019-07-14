package com.thoughtworks.tdd;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ParkingBoy {
    private Park park;

    public ParkingBoy(Park park) {
        this.park = park;
    }

    public String canPark(Car car, Park park) {
        if (this.park.getCarList().size() < 10) {
            return "OK";
        }
        return "FULL";
    }

    public Ticket parkAction(Car car, Park park) {
//        park.getCarList().add(car);
        Ticket ticket = new Ticket(UUID.randomUUID().toString().substring(0,5), car.getCarId(), true);
        park.getCarList().put(ticket.getTicketId(), car);
        return ticket;
    }

    public String canPick(Ticket ticket) {
        if (ticket != null && ticket.isValid()) {
            if (this.park.getCarList().get(ticket.getTicketId()) == null) {
                return "Unrecognized_ticket";
            }
            return "OK";
        } else if (ticket == null) {
            return "No_Ticket";
        } else if (!ticket.isValid()){
            return "Unrecognized_ticket";
        }
        return "NO_FOUND";
    }

    public Car pickByTicket(Ticket ticket) {
        Car car = this.park.getCarList().get(ticket.getTicketId());
        return car;
    }

    public Ticket servePark(Customer customer) {
        String parkMsg = canPark(customer.getCar(), this.park);
        Ticket ticket = null;
        if (parkMsg == "OK") {
            ticket = parkAction(customer.getCar(), this.park);
            customer.setTicket(ticket);
        } else if (parkMsg == "FULL") {
            customer.setServerMsg("Not enough position.");
        }
        return ticket;
    }

    public Car servePick(Customer customer) {
        String pickMsg = canPick(customer.getTicket());
        Car car = null;
        if (pickMsg == "OK") {
            car = pickByTicket(customer.getTicket());
            customer.getTicket().setValid(false);
        } else if (pickMsg == "Unrecognized_ticket"){
            customer.setServerMsg("Unrecognized parking ticket.");
        } else if (pickMsg == "No_Ticket") {
            customer.setServerMsg("Please provide your parking ticket.");
        }
        return car;
    }
}
