package org.bestwasabi.equipment;

import org.bestwasabi.basic.Equipment;

public class Weapon extends Equipment {
    private int weaponDamage;

    public Weapon(String name, int weaponDamage) {
        super(name);
        this.weaponDamage = weaponDamage;
    }

    public int applyDamage(int damage) {
        return damage + weaponDamage;
    }
}
