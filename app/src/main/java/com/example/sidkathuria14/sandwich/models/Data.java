package com.example.sidkathuria14.sandwich.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sidkathuria14 on 22/3/18.
 */

public class Data {
    @SerializedName("lang")
    @Expose
    String lang;

    @SerializedName("query")
    @Expose
    String query;

    @SerializedName("sessionId")
    @Expose
    String sessionId;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Data(String lang, String query, String sessionId) {
        this.lang = lang;
        this.query = query;
        this.sessionId = sessionId;
    }

    //    @Override
//    public String toString() {
//        return "Post{" +
//                "lang='" + lang + '\'' +
//                ", query='" + query + '\'' +
//                ", sessionId=" + sessionId +
//                '}';
//    }
}
