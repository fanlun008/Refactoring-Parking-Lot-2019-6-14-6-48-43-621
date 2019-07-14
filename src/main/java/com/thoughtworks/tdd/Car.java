package com.thoughtworks.tdd;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Car {
    private String carId;
    private String customerId;

    public Car(String carId) {
        this.carId = carId;
    }

    public Car(String carId, String customerId) {
        this.carId = carId;
        this.customerId = customerId;
    }
}
