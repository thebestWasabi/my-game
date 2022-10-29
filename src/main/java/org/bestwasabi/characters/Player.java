package org.bestwasabi.characters;

import org.bestwasabi.basic.GameCharacter;
import org.bestwasabi.equipment.Weapon;

public class Player extends GameCharacter {

    Weapon weapon = new Weapon("Короткий железный меч", 4);

    public Player(String name, int healthPoint, int defence, int strength, int attackPower, int xp, int gold) {
        super(name, healthPoint, defence, strength, attackPower, xp, gold, new Weapon("Короткий железный меч", 6));
    }
}
