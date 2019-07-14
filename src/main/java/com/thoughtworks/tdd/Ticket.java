package com.thoughtworks.tdd;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Ticket {
    private String ticketId;
    private String carId;
    private boolean valid;

    public Ticket(String ticketId, String carId, boolean valid) {
        this.ticketId = ticketId;
        this.carId = carId;
        this.valid = valid;
    }
}
