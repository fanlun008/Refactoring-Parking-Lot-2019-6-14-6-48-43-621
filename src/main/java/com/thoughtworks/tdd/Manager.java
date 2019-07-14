package com.thoughtworks.tdd;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Manager extends ParkingBoy{
    private String serveMsg;
    private Map<String, ParkingBoy> parkingBoyList = new HashMap<>();

    public Manager(String id) {
        super(id);
    }

    public Manager(Map<String, ParkingBoy> parkingBoyList) {
        this.parkingBoyList = parkingBoyList;
    }

    public Manager addParkBoy(ParkingBoy parkingBoy) {
        if (parkingBoy.getId() == null) {
            parkingBoy.setId("parkingBoy_"+UUID.randomUUID().toString().substring(0,5));
        }
        parkingBoyList.put(parkingBoy.getId(), parkingBoy);
        return this;
    }

    public String callParkBoyToPark(String parkBoyId, Customer customer) {
        ParkingBoy parkingBoy = this.getParkingBoyList().get(parkBoyId);
        if (parkingBoy == null) {
            serveMsg = "I have no this parkingBoy - " + parkBoyId;
            return "I have no this parkingBoy - " + parkBoyId;
        }
        Ticket ticket = parkingBoy.servePark(customer);
        if (ticket == null){
            this.serveMsg = customer.getServerMsg();
        }
        return this.serveMsg;
    }

    public String callParkBoyToPick(String parkBoyId, Customer customer) {
        ParkingBoy parkingBoy = this.getParkingBoyList().get(parkBoyId);
        if (parkingBoy == null) {
            serveMsg = "I have no this parkingBoy - " + parkBoyId;
            return "I have no this parkingBoy - " + parkBoyId;
        }
        Car car = parkingBoy.servePick(customer);
        this.serveMsg = customer.getServerMsg();
        return serveMsg;
    }
}
