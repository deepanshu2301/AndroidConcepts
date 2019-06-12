package com.dipanshu.customlistview;

public class SuperHeroes {

    private String name,universe,powers;

    public SuperHeroes(String name, String universe, String powers) {
        this.name = name;
        this.universe = universe;
        this.powers = powers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
        this.powers = powers;
    }



}
