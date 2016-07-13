package com.thirdmodule.thirdtask;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MusicShop shop = new MusicShop();
        shop.setGuitars(16);
        shop.setPianos(2);
        shop.setTrumpets(7);

        System.out.println(shop);

        Map<String, Integer> order = new HashMap<>();
        order.put("guitar", 8);
        order.put("piano", 1);
        order.put("trumpet", 6);

        try {
            List<Instrument> toRemove = prepareOder(shop, order);
            System.out.println("This order: " + toRemove);
        } catch (IllegalStateException ex) {
            System.out.println("There are not instruments in the stock!");
        }
        System.out.println(shop);
    }

    private static List<Instrument> prepareOder(MusicShop shop, Map<String, Integer> order) {
        int guitarsToRemove = order.get("guitar");
        int pianosToRemove = order.get("piano");
        int trumpetsToRemove = order.get("trumpet");

        if (shop.getGuitars() < guitarsToRemove || shop.getPianos() < pianosToRemove ||
                shop.getTrumpets() < trumpetsToRemove) throw new IllegalStateException();

        shop.setPianos(shop.getPianos() - pianosToRemove);
        shop.setGuitars(shop.getGuitars() - guitarsToRemove);
        shop.setTrumpets(shop.getTrumpets() - trumpetsToRemove);

        List<Instrument> result = new ArrayList<>();
        for (int i = 0; i < pianosToRemove; i++) {
            result.add(new Piano());
        }
        for (int i = 0; i < guitarsToRemove; i++) {
            result.add(new Guitar());
        }
        for (int i = 0; i < trumpetsToRemove; i++) {
            result.add(new Trumpet());
        }
        return result;
    }

    public void checkOrder(String key) {
        try {
            if ((!key.equals("guitar")) || (!key.equals("piano")) || (!key.equals("trumpet"))) {
                throw new WrongKeyException();
            }
        } catch (WrongKeyException ex) {
            System.out.println("You enter wrong key!");
        }
    }
}



