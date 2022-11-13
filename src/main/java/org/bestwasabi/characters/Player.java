package org.bestwasabi.characters;

import org.bestwasabi.basic.GameCharacter;
import org.bestwasabi.equipment.Weapon;

public class Player extends GameCharacter {

    Weapon sword = new Weapon("Длинный стальной меч", 10);

    public Player(String name, int hp, int defence, int strength, int attackPower, int xp, int gold) {
        super(name, hp, defence, strength, attackPower, xp, gold);
    }
}
