package com.example.mockito.controller;

import com.example.mockito.entity.Car;
import com.example.mockito.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CarController {

    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository){
        this.carRepository=carRepository;
    }

    public List<Car>getCars(){
        List<Car>list = new ArrayList<>();
        carRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Car addCar(Car car){
        return carRepository.save(car);
    }
    public boolean getTrue(){
        return true;
    }
}
