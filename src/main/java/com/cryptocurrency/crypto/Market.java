package com.cryptocurrency.crypto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Market {
    private String name;

    public Market() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
