package com.nhnacademy.mart;

import java.util.ArrayList;

public class Counter {
    public int pay(Basket basket) {
        ArrayList<Food> foods = basket.getFoods();
        int totalCost = 0;
        for (Food food : foods){
            totalCost += food.getPrice();
        }
        return totalCost;

    }



    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)

}
