import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TextLab06st {
    public static void main(String args[]) {
        System.out.println("\nTextLab06\n");

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the quantity of random numbers  ===>>  ");
        int listSize = scan.nextInt();
        scan.close();

        System.out.println();
        Statistics intList = new Statistics(listSize);
        intList.randomize();
        intList.computeMean();
        intList.computeMedian();
        intList.computeMode();
        intList.displayStats();
        System.out.println();
    }
}
