package org.bestwasabi.character;

import org.bestwasabi.equipment.Weapon;

public class Player extends GameCharacter {

    private Weapon weapon;

    public Player(String name, int hp, int defence, int strength, int attackPower, int xp, int gold) {
        super(name, hp, defence, strength, attackPower, xp, gold);

    }

    public void buyItems() {

    }

    public void sellItems() {

    }
}
