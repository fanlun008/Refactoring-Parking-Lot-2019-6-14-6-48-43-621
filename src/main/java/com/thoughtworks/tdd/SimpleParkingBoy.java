package com.thoughtworks.tdd;

import java.util.List;

public class SimpleParkingBoy extends ParkingAttendant{

    public SimpleParkingBoy(List<Park> parks) {
        super(parks);
    }

    @Override
    public Park findWhichParkCanPark() {
        for (Park park : getParkList()) {
            if (park.getCarList().size() >= park.getMaxSize()) {
                continue;
            } else {
                return park;
            }
        }
        return null;
    }
}
