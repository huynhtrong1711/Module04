package com.codegym.model;

public class Settings {
    private String Languages;
    private String size;
    private String spansFilter;
    private String signature;

    public Settings() {
    }

    public Settings(String languages, String size, String spansFilter, String signature) {
        Languages = languages;
        this.size = size;
        this.spansFilter = spansFilter;
        this.signature = signature;
    }

    public String getLanguages() {
        return Languages;
    }

    public void setLanguages(String languages) {
        Languages = languages;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpansFilter() {
        return spansFilter;
    }

    public void setSpansFilter(String spansFilter) {
        this.spansFilter = spansFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
