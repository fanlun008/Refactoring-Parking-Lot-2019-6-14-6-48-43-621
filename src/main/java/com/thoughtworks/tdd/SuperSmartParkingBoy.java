package com.thoughtworks.tdd;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<Park> parkList) {
        super(parkList);
    }

    @Override
    public Park findWhichParkCanPark() {
        long count = this.getParkList().stream()
                .filter((p1) -> p1.getCarList().size() < p1.getMaxSize()).count();
        if (count <= 0) {
            return null;
        } else {
            Park park = this.getParkList().stream()
                    .filter((p1) -> p1.getCarList().size() < p1.getMaxSize())
                    .reduce((p1, p2) ->
                            (double) p1.getCarList().size() / (double) p1.getMaxSize() > (double) p2.getCarList().size() / (double) p2.getMaxSize() ? p2 : p1)
                    .get();
            return park;
        }
    }
}
