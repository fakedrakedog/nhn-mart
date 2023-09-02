package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NhnMartTest {

    @Test
    public void testPrepareMart() {
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        FoodStand foodStand = mart.getFoodStand();
        int onionCount = 0;
        int eggCount = 0;
        int leekCount = 0;
        int appleCount = 0;
        for (Food food : foodStand.getFoods()) {
            switch (food.getName()) {
                case "양파":
                    onionCount++;
                    break;
                case "계란":
                    eggCount++;
                    break;
                case "파":
                    leekCount++;
                    break;
                case "사과":
                    appleCount++;
                    break;
            }
        }
        assertEquals(2, onionCount);
        assertEquals(5, eggCount);
        assertEquals(10, leekCount);
        assertEquals(20, appleCount);
    }


}