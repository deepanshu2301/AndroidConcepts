package com.dipanshu.pokidex;

import java.util.ArrayList;

public class Ability {
    private ArrayList<move> abilitytype;

    public Ability() {
        abilitytype = new ArrayList<>();
    }


    public ArrayList<move> getAbilitytype() {
        return abilitytype;
    }

    public void setAbilitytype(ArrayList<move> abilitytype) {
        this.abilitytype = abilitytype;
    }
}
