package jukebox_project;
import java.util.Scanner;

public class SongsMethod extends DisplayMenu  {
    Scanner sc = new Scanner(System.in);
    public Object displaySongs() {
        System.out.println("SONG NAME       | SONG ID |    ARTISTS    |   ALBUMS");
        System.out.println("----------------------------------------------------");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Dil Nu", 600, "AP Dhillon", "AP Dhillon Music");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Bad Habits", 601, "Ed Sheeran", "Divide");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Shivers", 602, "Ed Sheeran", "Divide");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Excuses", 605, "AP Dhillon", "AP Dhillon Music");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Thunder", 603, "Dragons", "Motivation");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Ghost", 604, "Justin Beiber", "Beiber");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Sunflower", 606, "Mellon", "Motivation");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Calm Down", 607, "Selena Gomez", "Selena Music");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Umbrella", 608, "Rihanna", "Rihanna Rocks");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Unstoppable", 609, "Sia", "Motivation");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Summer High", 610, "AP Dhillon", "AP Dhillon Music");
        System.out.printf("%-15s | %7d | %-13s | %-20s\n", "Dance Monkey", 611, "Tones&I", "Motivation");
        return null;
    }
    public void mainMenu(){
        System.out.println("Press 1 to goto Main Manu and Press 0 to Exit ");
        int ans = sc.nextInt();
        switch (ans) {
            case 1:

                break;
            case 2:
                System.out.println("Exited");

                break;
        }
    }

    }




