package com.example.mockito.api;

import com.example.mockito.controller.CarController;
import com.example.mockito.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    private CarController carController;

    @Autowired
    public Api(CarController carController){
        this.carController=carController;
    }
    @GetMapping("/cars")
    public Iterable<Car>getCars(){
        return carController.getCars();
    }

    @PostMapping("/cars")
    public void addCars(@RequestBody Car car){
        carController.addCar(car);
    }

}
