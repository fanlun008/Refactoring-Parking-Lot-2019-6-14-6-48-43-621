package com.thoughtworks.tdd;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.LinkedHashMap;
import java.util.Map;


@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Park {
    private String packId;
    private Integer maxSize = 10;

    private Manager manager;

    public Park(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Park(Manager manager) {
        this.manager = manager;
    }

    //    private List<Car> carList = new ArrayList<>();
    private Map<String, Car> carList = new LinkedHashMap<>();
}
