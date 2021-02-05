/**Programming Project 3 (RPG Sim)
* Class CS-21
* Section Number 73734
* Professor Whelan
* Ian Espinosa
* Sheikh Rahman & Eunice Lee
* 11/12/16
**/
import java.util.Scanner;
import java.util.Random;
public class ProgrammingProject3
{
    static int HP = 0;
    static int ATK = 0;
    static int HP_monster = 0;
    static int ATK_monster = 0;
    public static void main(String[]args)
    {
        Scanner console = new Scanner(System.in);
        String name;
        String choose = "";
        String enemy = "";
        do
        {
            System.out.println("Choose Your Race:");
            System.out.println("1. Dwarf – high hit points but low attack");
            System.out.println("2. Elf – low hit points and high attack");
            System.out.println("3. Human – balanced");
            choose = console.nextLine();
        }
        while(!choose.equals("Dwarf")&&!choose.equals("Elf")&&!choose.equals("Human"));
        //They don't input any numbers
        System.out.println("What Be Yer Name Brave Warrior?");
        name = console.nextLine();
        Players(choose);
        enemy = Enemies();
        Battle(name, enemy);
    }

    public static void Players(String character)
    {
        if (character.equals("Dwarf"))
        {
            HP = 60;
            ATK = 6;
        }
        else if (character.equals("Elf"))
        {
            HP = 30;
            ATK = 12;
        }
        else if (character.equals("Human"))
        {
            HP = 45;
            ATK = 9;
        }
    }

    public static String Enemies()
    {
        Random enemyGenerator = new Random();
        int random = enemyGenerator.nextInt(3)+1;
        String enemy = "";
        if (random == 1)
        {
            enemy = "Chanel";
            HP_monster = 10;
            ATK_monster = 2;
        }
        else if (random == 2)
        {
            enemy = "Bvlgari";
            HP_monster = 12;
            ATK_monster = 3;
        }
        else if (random == 3)
        {
            enemy = "Marc Jacobs";
            HP_monster = 200;
            ATK_monster = 150;
        }
        System.out.println("An enemy appears..." + enemy);
        return enemy;
    }
    
    public static void Battle(String name, String enemy)
    {
        do
        {
            Random Damage = new Random();
            int playerDamage = Damage.nextInt(ATK)+1;
            System.out.println("");
            System.out.println(name + " hits the enemy for " + playerDamage + " hit points! ");
            int enemyDamage = Damage.nextInt(ATK_monster)+1;
            System.out.println(enemy + " kicks " + name + " for " + enemyDamage + " hit points! ");
            HP = HP - enemyDamage;
            HP_monster = HP_monster - playerDamage;   
        }
        while (HP_monster > 0 && HP > 0 );
        System.out.println("");
        if (HP_monster < 0)
        {
            System.out.println(name + " has defeated " + enemy);
        }
        else if (HP <0)
        {
            System.out.println(enemy + " has devoured " + name);
        }
    }
}