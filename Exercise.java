package SolvdExercises;

import java.util.Scanner;

public class Exercise {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter the number of the month:");
        var month = Integer.parseInt(input.nextLine());
        var station = "Unknown station";

        switch(month){
            case 1: case 2: case 12:
                station = "Winter";
                break;
            case 3: case 4: case 5:
                station = "Spring";
                break;
            case 6: case 7: case 8:
                station = "Summer";
                break;
            case 9: case 10: case 11:
                station = "Autumn";
                break;
        }

        System.out.println("station = " + station);
    }
}
