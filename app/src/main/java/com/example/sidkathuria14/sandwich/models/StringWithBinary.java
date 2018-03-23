package com.example.sidkathuria14.sandwich.models;

/**
 * Created by sidkathuria14 on 23/3/18.
 */

public class StringWithBinary {
    int binary;
    String text;

    public void setBinary(int binary) {
        this.binary = binary;
    }

    public void settext(String text) {
        this.text = text;
    }

    public int getBinary() {
        return binary;
    }

    public String gettext() {
        return text;
    }

    public StringWithBinary(int binary, String text) {
        this.binary = binary;
        this.text = text;
    }
}
