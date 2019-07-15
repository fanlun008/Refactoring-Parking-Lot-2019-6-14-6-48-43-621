package com.thoughtworks.tdd;

import java.util.List;

public class SimpleParkingBoy extends ParkingAttendant{

    public SimpleParkingBoy(List<Park> parks) {
        super(parks);
    }

    @Override
    public Park findWhichParkCanPark() {
        Park park1 = getParkList().stream()
                .filter((park -> park.getCarList().size() < park.getMaxSize()))
                .findFirst().get();
        return park1;
    }
}
