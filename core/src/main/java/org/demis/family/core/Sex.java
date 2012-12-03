package org.demis.family.core;

public enum Sex {
    M ("M"),
    F ("F");

    private String name;

    Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
