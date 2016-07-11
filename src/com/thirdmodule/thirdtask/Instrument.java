package com.thirdmodule.thirdtask;

abstract class Instrument {
    public abstract String getKey();

    @Override
    public String toString() {
        return "Instrument "+getKey();
    }
}
