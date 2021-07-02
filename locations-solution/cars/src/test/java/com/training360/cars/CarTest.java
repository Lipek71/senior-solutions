package com.training360.cars;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void initCat(){
        Car car = new Car("Suzuki", "Vitara", 4, Condition.NORMAL, List.of(new KmState(LocalDate.of(2021,05,15),15000)));

        assertEquals(car.toString(),"Car{brand='Suzuki', type='Vitara', age=4, condition=NORMAL, kmStates=[KmState{date=2021-05-15, km=15000}]}");
        assertEquals(car.getAge(),4);
        assertEquals(car.getKmStates().get(0).getKm(),15000);
    }

}