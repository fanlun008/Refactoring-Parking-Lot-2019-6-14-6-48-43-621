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
    private String id;
    private List<Park> parkList;

    public ParkingBoy(String id) {
        this.id = id;
    }

    public ParkingBoy(List<Park> parkList) {
        this.parkList = parkList;
    }

    public ParkingBoy(String id, List<Park> parkList) {
        this.id = id;
        this.parkList = parkList;
    }

    public String canPark(Car car) {
        if (findWhichParkCanPark() != null) {
            return "OK";
        }
        return "FULL";
    }

    public Ticket parkAction(Car car, Park park) {
//        park.getCarList().add(car);
        Ticket ticket = new Ticket(UUID.randomUUID().toString().substring(0, 5), car.getCarId(), true);
        park.getCarList().put(ticket.getTicketId(), car);
        return ticket;
    }

    public Park findWhichParkCanPick(Ticket ticket) {
        for (Park park : this.parkList) {
            if (park.getCarList().get(ticket.getTicketId()) == null) {
                continue;
            } else {
                return park;
            }
        }
        return null;
    }

    public Ticket servePark(Customer customer) {
        String parkMsg = canPark(customer.getCar());
        Ticket ticket = null;
        if (parkMsg == "OK") {
            Park findWhichPark = findWhichParkCanPark();
            ticket = parkAction(customer.getCar(), findWhichPark);
            customer.setTicket(ticket);
        } else if (parkMsg == "FULL") {
            customer.setServerMsg("Not enough position.");
        }
        return ticket;
    }

    public Park findWhichParkCanPark() {
        for (Park park : this.parkList) {
            if (park.getCarList().size() >= 10) {
                continue;
            } else {
                return park;
            }
        }
        return null;
    }

    public String canPick(Ticket ticket) {
        if (ticket != null && ticket.isValid()) {
            if (findWhichParkCanPick(ticket) == null) {
                return "Unrecognized_ticket";
            }
            return "OK";
        } else if (ticket == null) {
            return "No_Ticket";
        } else if (!ticket.isValid()) {
            return "Unrecognized_ticket";
        }
        return "NO_FOUND";
    }

    public Car servePick(Customer customer) {
        String pickMsg = canPick(customer.getTicket());
        Car car = null;
        if (pickMsg == "OK") {
            car = pickByTicket(customer.getTicket());
            customer.getTicket().setValid(false);
        } else if (pickMsg == "Unrecognized_ticket") {
            customer.setServerMsg("Unrecognized parking ticket.");
        } else if (pickMsg == "No_Ticket") {
            customer.setServerMsg("Please provide your parking ticket.");
        }
        return car;
    }

    public Car pickByTicket(Ticket ticket) {
        Park whichParkCanPick = findWhichParkCanPick(ticket);
        Car car = whichParkCanPick.getCarList().get(ticket.getTicketId());
        return car;
    }
}
