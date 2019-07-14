package com.thoughtworks.tdd;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Customer {
    private String cusId;
    private Ticket ticket;
    private Car car;
    private String serverMsg;

    public Customer() {
    }

    public Customer(String cusId, Car car) {
        this.cusId = cusId;
        this.car = car;
        this.car.setCustomerId(this.cusId);
    }

    public Customer(Car car) {
        this.car = car;
        this.car.setCustomerId(this.cusId);
    }
}
