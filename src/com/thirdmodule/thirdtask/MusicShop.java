package com.thirdmodule.thirdtask;

import java.util.Map;

public class MusicShop {
    Map<String, Integer> instrument;

    public Map<String, Integer> getInstrument() {
        return instrument;
    }

    public void setInstrument(Map<String, Integer> instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "MusicShop has next music instrument " + instrument;
    }
}
