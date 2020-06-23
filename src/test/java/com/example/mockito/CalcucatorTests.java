package com.example.mockito;


import org.junit.Assert;
import org.junit.Test;

public class CalcucatorTests {

    @Test
    public void should_add_two_numbers(){
        //given
        Calculator calculator = new Calculator();
        //then
        Assert.assertEquals(calculator.add(10,15),25);

    }
    @Test
    public void should_no_add_two_numbers(){
        //given
        Calculator calculator = new Calculator();
        //then
        Assert.assertNotEquals(calculator.add(10,20),25);
    }

    @Test
    public void should_divide_two_numbers() {
        Calculator calculator = new Calculator();
        //then
        Assert.assertEquals(10,calculator.divide(100,10),0);
    }
    @Test(expected = ArithmeticException.class)
    public void should_no_divide_by_zero() {
        Calculator calculator = new Calculator();
        //then
        Assert.assertNotEquals(calculator.divide(100,0),10);
    }
}
