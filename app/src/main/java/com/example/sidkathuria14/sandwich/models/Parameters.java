package com.example.sidkathuria14.sandwich.models;

/**
 * Created by sidkathuria14 on 22/3/18.
 */

public class Parameters {
    String meat,condiments;

    public String getMeat() {
        return meat;
    }

    public String getCondiments() {
        return condiments;
    }

    public Parameters(String meat, String condiments) {
        this.meat = meat;
        this.condiments = condiments;
    }
}
