package com.thoughtworks.tdd;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Customer {
    private Ticket ticket;
    private Car car;

    public Customer() {
    }

    public Customer(Car car) {
        this.car = car;
    }
}
