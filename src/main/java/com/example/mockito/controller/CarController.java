package com.example.mockito.controller;

import com.example.mockito.entity.Car;
import com.example.mockito.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    public CarController( List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> cars;

    public CarController() {
        this.cars = new ArrayList<>();
    }

    @GetMapping
    public List<Car> getCars() {
        return cars;
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        cars.add(car);
    }


    @DeleteMapping
    public boolean deleteCar(@RequestParam Integer id) {
        return cars.removeIf(x -> x.equals(id));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Car car = new Car();
        car.setCarId(1);
        car.setModel("Audi");
        car.setWeight(1130);
        cars.add(car);
    }
}
