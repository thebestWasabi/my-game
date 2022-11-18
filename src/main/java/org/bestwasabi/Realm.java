package org.bestwasabi;

import org.bestwasabi.battle.Battle;
import org.bestwasabi.character.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Realm {

    private static BufferedReader br;              // класс для чтения введенных строк из консоли
    private static GameCharacter player = null;    // игрок должен храниться на протяжении всей игры
    private static Battle battle = null;           // класс для битвы можно не создавать каждый раз, а переиспользовать

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();
        System.out.print("Введите имя своего персонажа: ");
        try {
            commander(br.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void commander(String readLine) throws IOException {
        createHero(readLine);
        switch (readLine) {
            case "1":
                System.out.println("Торговец еще не приехал в город");
                commander(br.readLine());
                break;
            case "2":
                commitFight();
                break;
            case "3":
                System.exit(1);
                break;
            case "да":
                commander("2");
                break;
            case "нет":
                printNavigation();
                commander(br.readLine());
                break;
        }
        commander(br.readLine());
    }

    private static void createHero(String readLine) {
        if (player == null) {
            player = new Player(readLine, 100, 5, 10, 1, 0, 0);
            printNavigation();
        }
    }

    private static GameCharacter createMonster() {
        if (Math.random() <= 0.5) {
            return new Goblin("Гоблин", 25, 5, 10, 1, 10, 2);
        } else {
            return new Skeleton("Скелет-воин", 50, 5, 10, 1, 10, 2);
        }
    }

    private static void commitFight() {
        battle.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.printf("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья \n",
                        player.getName(), player.getXp(), player.getGold(), player.getHp());
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    commander(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void fightLost() {
                System.exit(1);
            }
        });
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }

}
