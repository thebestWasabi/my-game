package org.bestwasabi.basic;

import org.bestwasabi.characters.Fighter;
import org.bestwasabi.equipment.Armor;
import org.bestwasabi.equipment.Weapon;

public abstract class GameCharacter implements Fighter {

    private String name;
    private int hp;
    private int defence;
    private int strength;
    private int attackPower;
    private int damage;
    private int xp;
    private int gold;
    public Weapon weapon;
    public Armor armor;

    public GameCharacter() {
    }

    public GameCharacter(String name, int hp, int defence, int strength, int attackPower, int xp, int gold) {
        this(name, hp, defence, strength, attackPower, xp, gold, null);
    }

    public GameCharacter(String name, int hp, int defence, int strength, int attackPower, int xp, int gold, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.defence = defence;
        this.strength = strength;
        this.attackPower = attackPower;
        this.xp = xp;
        this.gold = gold;
        this.weapon = weapon;
    }

    @Override
    public int hitDamage() {
        int damage = (strength / 2) + attackPower;
        if (weapon != null) {
            damage = weapon.applyDamage(damage);
        }
        if (strength + randomCube() > defence) {
            return damage;
        } else {
            return 0;
        }
    }

    private int randomCube() {
        int min = 1;
        int max = 20;
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", healthPoint=" + hp +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
