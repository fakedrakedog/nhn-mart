package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CounterTest {

    @Test
    @DisplayName("pay 테스트")
    void payTest(){
        Basket basket = new Basket();
        Food food = new Food("양파", 1000);
        basket.add(food);
        assertEquals(1000,food.getPrice());
    }

}