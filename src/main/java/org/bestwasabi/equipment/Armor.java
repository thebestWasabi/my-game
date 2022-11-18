package org.bestwasabi.equipment;

public class Armor extends Equipment {
    private int defence;

    public Armor(String name, int defence) {
        super(name);
        this.defence = defence;
    }

    public int getDefence() {
        return defence;
    }
}
