package com.thoughtworks.tdd;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ParkingBoy {
    private Park park;

    public ParkingBoy(Park park) {
        this.park = park;
    }

    public String park(Car car, Park park) {
        park.getCarList().add(car);
        return "OK";
    }

    public String pick(Ticket ticket, Park park) {
        return "OK";
    }

    public Ticket servePark(Customer customer) {

        if (park(customer.getCar(), this.park) == "OK") {
            return new Ticket();
        } else {
            return null;
        }

    }

    public Car servePick(Customer customer) {

        if (pick(customer.getTicket(), this.park) == "OK") {
            return new Car();
        } else {
            return null;
        }

    }
}
