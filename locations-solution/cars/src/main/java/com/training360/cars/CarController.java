package com.training360.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class CarController {

    final private CarServices carServices;

    @Autowired
    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    @GetMapping("/cars")
    @ResponseBody
    public List<Car> listCars(){
        return carServices.carsList();
    }

    @GetMapping("/types")
    @ResponseBody
    public List<String> listTypes(){
        return carServices.typeList();
    }
}
