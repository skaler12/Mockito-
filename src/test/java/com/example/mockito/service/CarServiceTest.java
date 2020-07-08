package com.example.mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
class CarServiceTest {

    @Spy
    CarService carService;

    @Test
    void getDataFromApi() {
        given(carService.getDataFromApi()).willReturn(preapareMockData());
    }

    private String[] preapareMockData() {
        String[] cars =  {"Audi","Bmw"};
        return  cars;
    }

    @Test
    void sortDataFromApi() {
        String[]sorted = {"Audi","Bmw"};
        assertArrayEquals(sorted,carService.sortDataFromApi());
    }
}