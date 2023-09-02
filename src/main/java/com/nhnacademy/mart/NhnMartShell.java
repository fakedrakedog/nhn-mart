package com.nhnacademy.mart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NhnMartShell {

    public static void main(String[] args) throws IOException {
        MyLogger.getLogger().info("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();


        Customer hyunjoong = new Customer(buyList,20_000);

        // 장바구니를 챙긴다.
        hyunjoong.bring(mart.provideBasket());

        // 식품을 담는다.
        hyunjoong.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        hyunjoong.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() throws IOException {
        // TODO Scanner 입력을 받아 buyList 만들기

        BuyList buyList = new BuyList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            buyList.add(new BuyList.Item(name,amount));
        }
        br.close();
        return buyList;


    }
}
