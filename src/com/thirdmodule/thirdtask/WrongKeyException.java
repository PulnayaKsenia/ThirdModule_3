package com.thirdmodule.thirdtask;

public class WrongKeyException extends Exception {
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

