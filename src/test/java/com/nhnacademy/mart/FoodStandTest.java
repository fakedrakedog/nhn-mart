package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FoodStandTest {

    @Test
    public void testRemove() {
        FoodStand foodStand = new FoodStand();
        Food food = new Food("양파", 1_000);
        foodStand.add(food);

        foodStand.remove(food);
        assertEquals(0, foodStand.getFoods().size());

        try {
            foodStand.remove(food);
        } catch (IllegalArgumentException e) {
            assertEquals("매대가 비었습니다.", e.getMessage());
        }
    }

}