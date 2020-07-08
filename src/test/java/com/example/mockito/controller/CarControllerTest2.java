package com.example.mockito.controller;

import com.example.mockito.entity.Car;
import com.example.mockito.repository.CarRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;




@RunWith(MockitoJUnitRunner.class)
class CarControllerTest2 {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarController carController;

    @Before
    public void init(){
        given(carRepository.findAll()).willReturn(preapareMockData());
    }
    @Test
    void getCars() {
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
}