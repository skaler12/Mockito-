package com.example.mockito;

import com.example.mockito.entity.Car;
import com.example.mockito.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MockitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockitoApplication.class, args);
    }
        @Autowired
        private CarRepository carRepository;

        @EventListener(ApplicationReadyEvent.class)
        public void init(){
            carRepository.save(new Car(1,"Audi",1000));
            carRepository.save(new Car(2,"Bmw",1200));
        }


}
