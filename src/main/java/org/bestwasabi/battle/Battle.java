package org.bestwasabi.battle;

import org.bestwasabi.characters.FightCallback;
import org.bestwasabi.basic.GameCharacter;
import org.bestwasabi.characters.Player;

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
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Boolean makeHit(GameCharacter attacker, GameCharacter defender, FightCallback fightCallback) {
        int attackerHit = attacker.hitDamage();
        int defenderHealth = defender.getHp() - attackerHit;

        if (attackerHit != 0) {
            System.out.printf("Персонаж %s нанес урон в %d единиц персонажу %s \n", attacker.getName(), attackerHit, defender.getName());
            System.out.printf("У персонажа %s осталось %d единиц здоровья \n", defender.getName(), defenderHealth);
        } else {
            System.out.printf("%s промахнулся! \n", attacker.getName());
        }

        if (defenderHealth <= 0 && defender instanceof Player) {
            System.out.println("Извините, вы пали в бою...");
            fightCallback.fightLost();
            return true;
        } else if (defenderHealth <= 0) {
            System.out.printf("Враг повержен! Вы получаете %d ед опыта и %d золота \n", defender.getXp(), defender.getGold());
            attacker.setXp(attacker.getXp() + defender.getXp());
            attacker.setGold(attacker.getGold() + defender.getGold());
            fightCallback.fightWin();
            return true;
        } else {
            defender.setHp(defenderHealth);    //если защищающийся не повержен, то задаем ему новый уровень здоровья
            return false;
        }
    }

}
