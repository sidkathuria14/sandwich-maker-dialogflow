package com.example.sidkathuria14.sandwich.models;

/**
 * Created by sidkathuria14 on 22/3/18.
 */

public class Result {
    String source,speech,resolvedQuery,action;
    Parameters parameters;


    public String getSource() {
        return source;
    }

    public String getSpeech() {
        return speech;
    }

    public String getResolvedQuery() {
        return resolvedQuery;
    }

    public String getAction() {
        return action;
    }

    public Parameters getParameters() {
        return parameters;
    }
}
