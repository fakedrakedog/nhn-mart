package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {
    private final ArrayList<Food> foods = new ArrayList<>();
    public void add(Food food) {
        foods.add(food);
    }
    public void remove(Food food) {
        if (foods.isEmpty()) {
            MyLogger.getLogger().warning("빈 매대");
            throw new IllegalArgumentException("매대가 비었습니다.");
        }
        boolean found = false;
        for (int i = 0; i < foods.size(); i++) {
            if (food.equals(foods.get(i))){
                foods.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            MyLogger.getLogger().warning("존재 하지 않음");
            throw new IllegalArgumentException(food.getName() + "(은)는 존재 하지 않습니다.");
        }
    }

    public ArrayList<Food> getFoods(){
        return foods;
    }




}
