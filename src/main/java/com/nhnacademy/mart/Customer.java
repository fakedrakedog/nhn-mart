package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    private int balance;

    public Customer(BuyList buyList, int initialbalance) {
        this.buyList = buyList;
        this.balance = initialbalance;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }
    public void pickFoods(FoodStand foodStand) {
        ArrayList<BuyList.Item> items = buyList.getItems();
        for (BuyList.Item item : items) {
            String name = item.getName();
            int amount = item.getAmount();
            int count = 0;
            for (Food food : foodStand.getFoods()) {
                if (food.getName().equals(name)) {
                    count++;
                }
            }
            if (count == 0) {
                MyLogger.getLogger().warning("존재하지 않음");
                throw new IllegalArgumentException(name + "(은)는 존재하지않습니다.");
            } else if (count < amount) {
                MyLogger.getLogger().warning("재고가 부족함");
                throw new IllegalArgumentException(name + "의 재고가 부족합니다.");
            }
            for (int i = 0; i < amount; i++) {
                for (int j = 0; j < foodStand.getFoods().size(); j++) {
                    Food food = foodStand.getFoods().get(j);
                    if (food.getName().equals(name)) {
                        basket.add(food);
                        foodStand.getFoods().remove(j);
                        break;
                    }
                }
            }
        }
    }

    public void payTox(Counter counter) {
        int totalCost = counter.pay(basket);
        if (balance < totalCost) {
            MyLogger.getLogger().warning("잔액 부족 발생");
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        balance -= totalCost;
        counter.pay(basket);
        MyLogger.getLogger().info("총 가격은 " + totalCost + "원 입니다.");
        MyLogger.getLogger().info("고객님 결제 후 잔액 : " + balance);

    }

    // TODO payTox 메서드 구현


        // TODO pickFoods 메서드 구현





}
