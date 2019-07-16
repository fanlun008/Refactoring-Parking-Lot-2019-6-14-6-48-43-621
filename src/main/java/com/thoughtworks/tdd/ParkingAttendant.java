package com.thoughtworks.tdd;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public abstract class ParkingAttendant {
    private String id;
    private List<Park> parkList;

    public ParkingAttendant(List<Park> parkList) {
        this.parkList = parkList;
    }

    public ParkingAttendant(String id, List<Park> parkList) {
        this.id = id;
        this.parkList = parkList;
    }

    public Ticket servePark(Customer customer) {
        ServeMessage parkMsg = canPark(customer.getCar());
        Ticket ticket = null;
        if (parkMsg == ServeMessage.OK) {
            Park findWhichPark = findWhichParkCanPark();
            ticket = parkAction(customer.getCar(), findWhichPark);
            customer.setTicket(ticket);
        } else if (parkMsg == ServeMessage.FULL) {
            customer.setServerMsg(ServeMessage.FULL.getValue());
        }
        return ticket;
    }

    public ServeMessage canPark(Car car) {
        if (findWhichParkCanPark() != null) {
            return ServeMessage.OK;
        }
        return ServeMessage.FULL;
    }

    public Ticket parkAction(Car car, Park park) {
        Ticket ticket = new Ticket(UUID.randomUUID().toString().substring(0, 5), car.getCarId(), true);
        park.getCarList().put(ticket.getTicketId(), car);
        return ticket;
    }

    public abstract Park findWhichParkCanPark();
    public Park findWhichParkCanPick(Ticket ticket){
        for (Park park : getParkList()) {
            if (park.getCarList().get(ticket.getTicketId()) == null) {
                continue;
            } else {
                return park;
            }
        }
        return null;
    }

    public ServeMessage canPick(Ticket ticket) {
        if (ticket != null && ticket.isValid()) {
            if (findWhichParkCanPick(ticket) == null) {
                return ServeMessage.UNRECOGNIZED_TICKET;
            }
            return ServeMessage.OK;
        } else if (ticket == null) {
            return ServeMessage.NO_PROVIDED_TICKET;
        } else if (!ticket.isValid()) {
            return ServeMessage.UNRECOGNIZED_TICKET;
        }
        return ServeMessage.NO_FOUND;
    }

    public Car servePick(Customer customer) {
        ServeMessage pickMsg = canPick(customer.getTicket());
        Car car = null;
        if (pickMsg == ServeMessage.OK) {
            car = pickByTicket(customer.getTicket());
            customer.getTicket().setValid(false);
        } else if (pickMsg == ServeMessage.UNRECOGNIZED_TICKET) {
            customer.setServerMsg(ServeMessage.UNRECOGNIZED_TICKET.getValue());
        } else if (pickMsg == ServeMessage.NO_PROVIDED_TICKET) {
            customer.setServerMsg(ServeMessage.NO_PROVIDED_TICKET.getValue());
        }
        return car;
    }

    public Car pickByTicket(Ticket ticket) {
        Park whichParkCanPick = findWhichParkCanPick(ticket);
        Car car = whichParkCanPick.getCarList().get(ticket.getTicketId());
        whichParkCanPick.getCarList().remove(ticket.getTicketId());
        return car;
    }

}
