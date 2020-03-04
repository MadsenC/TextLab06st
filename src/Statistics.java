import java.util.Arrays;
import java.util.Random;

public class Statistics {

    private int list[];
    private int size;
    private double mean;
    private double median;
    private int mode;
    public double sum = 0;

    public Statistics(int s) {
        size = s;
        list = new int[size];
        mean = median = mode = 0;
    }

    public void randomize() {
        Random rand = new Random(12345);
        for (int k = 0; k < size; k++)
            list[k] = rand.nextInt(31) + 1;  // range of 1..31
    }

    public void computeMean() {
        for(int z = 0; z < list.length; z++) {
            sum += list[z];
        }
        mean = sum / list.length;
    }

    public void computeMedian() {
        Arrays.sort(list);
        if(list.length % 2 == 0) {
            int value = list.length / 2;
            median = (double)(list[value] + list [value - 1]) / 2;
        } else {
            median = (double)list[list.length / 2];
        }
    }

    public void computeMode() {
        Arrays.sort(list);
        int max_count = 1, res = list[0];
        int curr_count = 1;

        for (int i = 1; i < list.length; i++) {
            if (list[i] == list[i - 1])
                curr_count++;
            else {
                if (curr_count > max_count) {
                    max_count = curr_count;
                    res = list[i - 1];
                }
                curr_count = 1;
            }
        }
        // Fail Safe Method
        if (curr_count > max_count) {
            max_count = curr_count;
            res = list[list.length - 1];
        }
        mode = res;
    }

    public void displayStats() {
        System.out.println(Arrays.toString(list));
        System.out.println();
        System.out.println("Mean:    " + mean);
        System.out.println("Median:  " + median);
        System.out.println("Mode:    " + mode);
    }

}
