package com.thirdmodule.thirdtask;

import java.util.List;

public class MusicShop {
    private int pianos;
    private int guitars;
    private int trumpets;

    public int getPianos() {
        return pianos;
    }

    public void setPianos(int pianos) {
        this.pianos = pianos;
    }

    public int getGuitars() {
        return guitars;
    }

    public void setGuitars(int guitars) {
        this.guitars = guitars;
    }

    public int getTrumpets() {
        return trumpets;
    }

    public void setTrumpets(int trumpets) {
        this.trumpets = trumpets;
    }

    @Override
    public String toString() {
        return "There are " + pianos + " pianos, " + guitars + " guitars, " + trumpets + " trumpets in the music shop";
    }
}
