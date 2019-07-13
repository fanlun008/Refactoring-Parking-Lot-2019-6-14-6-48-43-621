package com.thoughtworks.tdd;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;


@Data
@Accessors(chain = true)
public class Park {

    private List<Car> carList = new ArrayList<>();
}
