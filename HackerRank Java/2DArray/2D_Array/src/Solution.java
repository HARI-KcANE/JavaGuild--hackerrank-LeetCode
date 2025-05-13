import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // The input is a 6x6 2D List of Integers.
        List<List<Integer>> arr = new ArrayList<>();

        // Read the 6x6 array from standard input.
        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        bufferedReader.close();

        // --- Hourglass Sum Calculation ---

        // Initialize maxSum to the smallest possible integer value.
        // This ensures that any valid hourglass sum will be greater.
        // The smallest possible sum for an hourglass is 7 elements * -9 (min value per element) = -63.
        // Integer.MIN_VALUE is a safer choice.
        int maxSum = Integer.MIN_VALUE;

        // Iterate through all possible top-left positions of an hourglass.
        // An hourglass is 3x3, so the top-left element (r, c) can only go up to
        // row 3 (0-indexed) and column 3 (0-indexed) to fit within the 6x6 grid.
        // 6 rows - 3 rows (hourglass height) = 3, so max r is 3 (0, 1, 2, 3)
        // 6 cols - 3 cols (hourglass width) = 3, so max c is 3 (0, 1, 2, 3)
        for (int r = 0; r <= 3; r++) { // Row index for the top-left of the hourglass
            for (int c = 0; c <= 3; c++) { // Column index for the top-left of the hourglass

                // Calculate the sum of the current hourglass
                // Hourglass pattern:
                // a b c
                //   d
                // e f g

                // Top row of the hourglass
                int sum_top_row = arr.get(r).get(c)     // a
                        + arr.get(r).get(c+1)   // b
                        + arr.get(r).get(c+2);  // c

                // Middle element of the hourglass
                int sum_middle_element = arr.get(r+1).get(c+1); // d

                // Bottom row of the hourglass
                int sum_bottom_row = arr.get(r+2).get(c)   // e
                        + arr.get(r+2).get(c+1) // f
                        + arr.get(r+2).get(c+2); // g

                // Total sum for the current hourglass
                int currentHourglassSum = sum_top_row + sum_middle_element + sum_bottom_row;

                // If the current hourglass sum is greater than the maximum sum found so far,
                // update maxSum.
                if (currentHourglassSum > maxSum) {
                    maxSum = currentHourglassSum;
                }
            }
        }

        // Print the maximum hourglass sum found.
        System.out.println(maxSum);
    }
}
