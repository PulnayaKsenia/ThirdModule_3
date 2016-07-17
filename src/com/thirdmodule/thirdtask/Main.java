package com.thirdmodule.thirdtask;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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
            List<Instrument> remainInstrument = prepareInstrument(shop, order);
            System.out.println("Remaining instrument in the stock: " + remainInstrument);
            if (order.keySet() != shop.keySet()) {
                throw new WrongKeyException();
            }
        } catch (IllegalStateException ex) {
            System.out.println("There are not instruments in the stock!");
        } catch (WrongKeyException e) {
            System.out.println("No such instruments!");
        }
    }

    public static List<Instrument> prepareInstrument(Map<String, Integer> shop, Map<String, Integer> order) {
        int guitarsToRemove = order.get("guitar");
        int pianosToRemove = order.get("piano");
        int trumpetsToRemove = order.get("trumpet");

        if (shop.get("guitar") < guitarsToRemove || shop.get("piano") < pianosToRemove ||
                shop.get("trumpet") < trumpetsToRemove) throw new IllegalStateException();

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
}




