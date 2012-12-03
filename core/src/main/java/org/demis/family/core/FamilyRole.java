package org.demis.family.core;


public enum FamilyRole {
    F ("F"),
    M ("M"),
    C ("C");

    private String name;

    FamilyRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
