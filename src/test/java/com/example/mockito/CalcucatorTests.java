package com.example.mockito;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalcucatorTests {

    @Test
    public void should_add_two_numbers(){
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.add(10,15);
        //then
        Assert.assertEquals(result,25);

    }
}
