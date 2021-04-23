package com.cryptocurrency.crypto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {
    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    private String ask;
    private String bid;

    @Override
    public String toString() {
        return "Ticker{" +
                "ask='" + ask + '\'' +
                ", bid='" + bid + '\'' +
                '}';
    }

    public Ticker() {
    }
}
