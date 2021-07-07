package com.training360.cars;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServices {

    List<Car> cars = List.of(
            new Car("Opel", "Insignia", 5, Condition.NORMAL, List.of(
                    new KmState(LocalDate.of(2018,10,15), 50000),
                    new KmState(LocalDate.of(2020,5,13), 80000)
            )),
            new Car("Opel", "Insignia", 8, Condition.BAD, List.of(
                    new KmState(LocalDate.of(2015,7,18), 40000),
                    new KmState(LocalDate.of(2021,4,7), 90000)
            )),
            new Car("VW", "Touran", 3, Condition.PERFECT, List.of(
                    new KmState(LocalDate.of(2019,3,18), 20000),
                    new KmState(LocalDate.of(2021,4,7), 60000)
            )),
            new Car("BMW", "X5", 4, Condition.NORMAL, List.of(
                    new KmState(LocalDate.of(2018,2,28), 20000),
                    new KmState(LocalDate.of(2021,9,7), 75000)
            ))
    );

    public List<Car> carsList(){
        return cars;
    }

    public List<String> typeList(){
        List<String> carTypeList = new ArrayList<>();
        for(int i= 0; i < cars.size(); i++){
            if(!carTypeList.contains(cars.get(i).getType())){
                carTypeList.add(cars.get(i).getType());
            }
        }
        return carTypeList;
    }

}
