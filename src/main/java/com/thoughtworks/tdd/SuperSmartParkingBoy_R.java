package com.thoughtworks.tdd;

public class SuperSmartParkingBoy_R extends ParkingAttendant {
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
