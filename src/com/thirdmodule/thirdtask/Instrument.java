package com.thirdmodule.thirdtask;

public class Instrument {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Instrument " + name;
    }
}
