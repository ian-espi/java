//Ian Espinosa, 12/13/2016, Tuesdays/Thursdays 3:45-6pm
import java.io.*;
import java.util.*;
public class Final
{
    public static void main(String[]args) throws FileNotFoundException
    {
        File a = new File ("testscores.txt");
        Scanner input = new Scanner(a);
        int [] score = new int[30];
        int [] id_number = new int [30];
        String [] name = new String [30];
        int i = 0; 
        while (input.hasNextInt())
        {
            id_number[i] = input.nextInt();
            score[i] = input.nextInt();
            name[i] = input.nextLine();
            i++;
        }
        printRoster(name, id_number);
        printLowest(name, score, id_number);
        printHighest(name, score, id_number);
    }
    
    public static void printRoster(String [] name, int [] id_number)
    {
        int i = 0;
         while (i < name.length) 
      {
          System.out.println(name[i] + " " + id_number[i]);
          i++;
      }
    }
    
    public static void printLowest(String [] name, int [] id_number, int [] score)
    {
        int i = 0;
        int lowest_score = 100;
        int number = 0;
        String student = "";
        while (i < name.length)
        {
            if (score[i] <= lowest_score && score[i] != number)
            {
                lowest_score = score[i];
                student = name[i];
                number = id_number[i];
            }
            i++;
        }
        System.out.println(student + " " + number + " " + lowest_score);
    }
    
    public static void printHighest(String [] name, int [] id_number, int [] score)
    {
        int i = 0;
        int highest_score = 99;
        String ace = "";
        int number2 = 0;
        while (i < name.length)
        {
            if (score[i] > highest_score)
            {
                highest_score = score[i];
                ace = name[i];
                number2 = id_number[i];
            }
            i++;
        }
        System.out.println(ace + " " + number2 + " " + highest_score);
    }
}