package com.aqulasoft.aquariumcalculator;

public class Fish {
    private String name;
    private float length;
    private float height;
    private String kind;

    public Fish(String name, float length, float height, String kind) {
        this.name = name;
        this.length = length;
        this.height = height;
        this.kind = kind;
    }

    public String getName() {
        return this.name;
    }

    public float getLength() {
        return this.length;
    }

    public float getHeight() {
        return this.height;
    }

    public String getKind() {
        return this.kind;
    }
}
