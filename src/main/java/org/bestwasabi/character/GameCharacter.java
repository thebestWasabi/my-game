package org.bestwasabi.character;

import org.bestwasabi.equipment.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class GameCharacter implements Fighter {

    private String name;
    private int hp;
    private int defence;
    private int strength;
    private int attackPower;
    private int xp;
    private int gold;
    private Weapon weapon;

    private List<Integer> allItems = new ArrayList<>();
    private List<Integer> equippedItems = new ArrayList<>();

    public GameCharacter() {

    }

    public GameCharacter(String name, int hp, int defence, int strength, int attackPower, int xp, int gold) {
        this.name = name;
        this.hp = hp;
        this.defence = defence;
        this.strength = strength;
        this.attackPower = attackPower;
        this.xp = xp;
        this.gold = gold;
    }

    // buy item


    // sell

    public void equipped(int id) {
        if (allItems.contains(id) && !equippedItems.contains(id)) {
            equippedItems.add(id);
        }
    }

    public void unequipped(int id) {
        if (equippedItems.contains(id)) {
            equippedItems.remove(id);
        }
    }

    @Override
    public int hitDamage() {
        int damage = attackPower;
        if (weapon != null) {
            damage = weapon.applyDamage(damage);
        }
        return hitOrMiss(damage);
    }

    private int hitOrMiss(int damage) {
        if ((strength / 2) + randomCube() > defence) {
            if (randomCube() == 20) damage *= 2;
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
