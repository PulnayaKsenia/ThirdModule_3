package com.thirdmodule.thirdtask;

public class WrongKeyException extends Exception {
    private String keyInstrument;

    public void setKeyInstrument(String keyInstrument) {
        this.keyInstrument = keyInstrument;
    }

    public String getKeyInstrument() {
        return keyInstrument;
    }
}

