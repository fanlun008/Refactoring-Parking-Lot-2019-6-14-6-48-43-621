package com.thoughtworks.tdd;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Data
@Accessors(chain = true)
public class Park {

//    private List<Car> carList = new ArrayList<>();
    private Map<String, Car> carList = new LinkedHashMap<>();
}
