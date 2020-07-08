package com.example.mockito.controller;

import com.example.mockito.entity.Car;
import com.example.mockito.repository.CarRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarControllerTest {
//BDD
    @Test
    void getCars() {
        //given
        //zamiast ten  linijki mozna dac po prostu @Mock i CarController carController 
    CarController carController = mock(CarController.class);
        given(carController.getCars()).willReturn(preapareMockData());
        //when
        List<Car>cars=carController.getCars();
        //then
        Assert.assertThat(cars, Matchers.hasSize(2));
    }
    public List<Car> preapareMockData(){
        List<Car>cars=new ArrayList<>();
        cars.add(new Car(1,"Audi",1000));
        cars.add( new Car(2,"Bmw",1200));
        return cars;
    }

    @Test
    public void addCar() {
        //given
        CarController carController = mock(CarController.class);
        given(carController.addCar(Mockito.any(Car.class))).willReturn(new Car(1,"Bmw",2000));
        //when
        Car car = carController.addCar(new Car());
        //then
        Assert.assertEquals(car.getModel(),"Bmw");
    }
}