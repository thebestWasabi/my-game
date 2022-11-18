package org.bestwasabi.battle;

import org.bestwasabi.character.FightCallback;
import org.bestwasabi.character.GameCharacter;
import org.bestwasabi.character.Player;

public class Battle {

    public void fight(GameCharacter character1, GameCharacter character2, FightCallback fightCallback) {
        Runnable runnable = () -> {
            int turn = 1;
            boolean isFightingEnded = false;

            while (!isFightingEnded) {
                System.out.println("Ход: " + turn);
                if (turn++ % 2 != 0)
                    isFightingEnded = makeHit(character1, character2, fightCallback);
                else
                    isFightingEnded = makeHit(character2, character1, fightCallback);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Boolean makeHit(GameCharacter attacker, GameCharacter defender, FightCallback fightCallback) {
        hitOrMiss(attacker, defender);
        return killedOrDied(attacker, defender, fightCallback);
    }

    private static Boolean killedOrDied(GameCharacter attacker, GameCharacter defender, FightCallback fightCallback) {
        if (defender.getHp() - attacker.hitDamage() <= 0 && defender instanceof Player) {
            System.out.println("Вас убили...");
            fightCallback.fightLost();
            return true;
        } else if (defender.getHp() - attacker.hitDamage() <= 0) {
            attacker.setXp(attacker.getXp() + defender.getXp());
            attacker.setGold(attacker.getGold() + defender.getGold());
            System.out.printf("Враг повержен! Вы получаете %d ед опыта и %d золота \n", defender.getXp(), defender.getGold());
            fightCallback.fightWin();
            return true;
        } else {
            defender.setHp(defender.getHp() - attacker.hitDamage());    //если защищающийся не повержен, то задаем ему новый уровень здоровья
            return false;
        }
    }

    private static void hitOrMiss(GameCharacter attacker, GameCharacter defender) {
        if (attacker.hitDamage() != 0) {
            System.out.printf("Персонаж %s нанес урон в %d единиц персонажу %s \n", attacker.getName(), attacker.hitDamage(), defender.getName());
            System.out.printf("У персонажа %s осталось %d единиц здоровья \n", defender.getName(), defender.getHp() - attacker.hitDamage());
        } else {
            System.out.printf("%s промахнулся! \n", attacker.getName());
        }
    }
}
