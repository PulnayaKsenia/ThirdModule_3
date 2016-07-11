package com.thirdmodule.thirdtask;

import java.util.*;

public class Main {
    public static void main(String[] args) throws OtherKeyException {
        MusicShop shop = new MusicShop();

        ArrayList<Instrument> instruments = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            instruments.add(new Guitar());
        }
        for (int i = 1; i < 2; i++) {
            instruments.add(new Piano());
        }
        for (int i = 1; i < 7; i++) {
            instruments.add(new Trumpet());
        }
        shop.setInstruments(instruments);

        Map<String, Integer> order = new HashMap<>();
        order.put("guitar", 8);
        order.put("piano", 1);
        order.put("trumpet", 6);

        System.out.println(shop);

        try {
            List<Instrument> forRemove = listForRemove(shop, order);
            removeFromTheShop(shop, order);
            System.out.println("This order : " + forRemove);
        } catch (IllegalStateException ex) {
            System.out.println("There are not instruments in stock!");
        }
        System.out.println(shop);
    }

    private static List<Instrument> listForRemove(MusicShop shop, Map<String, Integer> order) {
        List<Instrument> result = new ArrayList<>();

        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String instrumentKey = orderEntry.getKey();
            Integer numberToBeRemoved = orderEntry.getValue();

            int numberRemoved = 0;

            for (Instrument instrument : shop.getInstruments()) {
                if (instrument.getKey().equals(instrumentKey) && numberRemoved < numberToBeRemoved) {
                    result.add(instrument);
                    numberRemoved++;
                }
            }
            if (numberRemoved < numberToBeRemoved)
                throw new IllegalArgumentException("Shop does not have enough " + instrumentKey + "s");
        }

        return result;
    }

    private static void removeFromTheShop(MusicShop shop, Map<String, Integer> order) {
        for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
            String instrumentKey = orderEntry.getKey();
            Integer numberToBeRemoved = orderEntry.getValue();
            int numberRemoved = 0;

            for (int i = 0; i < shop.getInstruments().size(); i++) {
                if (shop.getInstruments().get(i).getKey().equals(instrumentKey) && numberRemoved < numberToBeRemoved) {
                    shop.getInstruments().remove(i);
                    numberRemoved++;
                }
            }
        }
    }

}

