package com.dipanshu.cars_lv;

public class Cars {
   private String name,colour,capacity;

    public Cars(String name, String colour, String capacity) {
        this.name = name;
        this.colour = colour;
        this.capacity = capacity;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCapacity() {
        return capacity;
    }
}
