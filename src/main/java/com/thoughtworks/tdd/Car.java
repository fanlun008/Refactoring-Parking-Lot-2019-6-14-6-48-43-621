package com.thoughtworks.tdd;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Car {
    private String carId;
    private String customerId;
}
