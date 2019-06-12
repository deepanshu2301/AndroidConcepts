package com.dipanshu.pokidex;

import java.util.ArrayList;

public class Details {

    private String name;
    private String weight;
    private String height;
//    private ArrayList<result> moves = new ArrayList<>();
//    private ArrayList<result> abilities = new ArrayList<>();


    Details(String name, String weight, String height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
//        this.abilities=abilities;
//        this.moves=moves;
    }

    public Details() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
//
//    public ArrayList<result> getMoves() {
//        return moves;
//    }
//
//    public void setMoves(ArrayList<move> moves) {
//        this.moves = moves;
//    }
//
//    public ArrayList<result> getAbilities() {
//        return abilities;
//    }
//
//    public void setAbilities(ArrayList<Ability> abilities) {
//        this.abilities = abilities;
//    }
}
