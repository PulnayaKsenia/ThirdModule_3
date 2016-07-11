package com.thirdmodule.thirdtask;

public class OtherKeyException extends Exception {
    String key;

    public OtherKeyException(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
