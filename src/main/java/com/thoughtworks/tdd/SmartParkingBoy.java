package com.thoughtworks.tdd;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(String id, List<Park> parkList) {
        super(id, parkList);
    }

    public SmartParkingBoy(List<Park> parkList) {
        super(parkList);
    }

    @Override
    public Park findWhichParkCanPark() {
        long count = this.getParkList().stream()
                .filter((p1) -> p1.getCarList().size() < p1.getMaxSize()).count();
        if (count <= 0) {
            return null;
        }else {
            Park park = this.getParkList().stream()
                    .filter((p1) -> p1.getCarList().size() < p1.getMaxSize())
                    .reduce((p1, p2) -> p1.getCarList().size() > p2.getCarList().size() ? p2 : p1)
                    .get();
            return park;
        }
    }
}
