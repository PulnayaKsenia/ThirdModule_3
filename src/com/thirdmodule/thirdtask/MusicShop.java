package com.thirdmodule.thirdtask;

import java.util.List;

class MusicShop {
    List<Instrument> instruments;

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return "MusicShop " +
                "instruments: " + instruments;
    }
}
