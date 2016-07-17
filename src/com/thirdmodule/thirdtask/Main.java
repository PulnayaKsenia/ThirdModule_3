package com.thirdmodule.thirdtask;

import java.util.*;

public class Main {
    public static void main(String[] args) throws WrongKeyException {
        System.out.println("HELLO! This is our music shop!");

        Map<String, Integer> shop = new HashMap<>();
        shop.put("guitar", 16);
        shop.put("piano", 2);
        shop.put("trumpet", 7);
        shop.put("violin", 5);
        shop.put("drum", 4);

        System.out.println("The following instruments are available:");
        for (Map.Entry shopInstrument : shop.entrySet()) {
            System.out.println("Key: " + shopInstrument.getKey() + "; Value: " + shopInstrument.getValue());

            if (shopInstrument.getValue().equals(0)) {
                System.out.println("This item is absent in the stock");
            }
        }

        Map<String, Integer> order = new HashMap<>();
        order.put("guitar", 8);
        order.put("piano", 1);
        order.put("trumpet", 6);

        System.out.println("New order:");
        for (Map.Entry orderNew : order.entrySet()) {
            System.out.println("Key: " + orderNew.getKey() + "; Value: " + orderNew.getValue());
         }

        try {
            Map<String, Integer> remainInstrument = afterOrder(shop, order);
            System.out.println("Remaining instrument in the stock: " + remainInstrument);
        } catch (IllegalStateException ex) {
            System.out.println("There are not instruments in the stock!");
        }
    }

    private static Map<String, Integer> afterOrder(Map<String, Integer> shop, Map<String, Integer> order) {
        int guitarsToRemove = order.get("guitar");
        int pianosToRemove = order.get("piano");
        int trumpetsToRemove = order.get("trumpet");

        if (shop.get("guitar") < guitarsToRemove || shop.get("piano") < pianosToRemove ||
                shop.get("trumpet") < trumpetsToRemove) throw new IllegalStateException();

        int valueGuitar = shop.get("guitar");
        shop.put("guitar", valueGuitar - 8);
        int valuePiano = shop.get("piano");
        shop.put("piano", valuePiano - 1);
        int valueTrumpet = shop.get("trumpet");
        shop.put("trumpet", valueTrumpet - 6);

        return shop;
    }
}




