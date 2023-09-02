package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    @DisplayName("pickfoods 테스트")
    void pickFoodsFoodstand() {
        Basket basket = new Basket();
        assertEquals(0,basket.getFoods().size());
        for (int i = 0; i < 2; i++) {
            basket.add(new Food("양파", 1_000));
        }
        assertEquals(2,basket.getFoods().size());

    }

    @Test
    @DisplayName("재고부족 테스트")
    void outofstocktest(){
        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("사과", 1000));

        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("사과", 2));

        Customer customer = new Customer(buyList,20000);

        assertThrows(IllegalArgumentException.class, () -> customer.pickFoods(foodStand));
    }

    @Test
    void payTox() {
        Basket basket = new Basket();
        Counter counter = new Counter();
        basket.add(new Food("양파,",2000));
        int totalCost = counter.pay(basket);
        assertEquals(2000,totalCost);

    }
}