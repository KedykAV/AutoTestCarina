package com.qaprosoft.carina.demo.utils;

public enum Languages {
    ENG("EN"),
    ESP("ES");
    public final String name;

    Languages (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
