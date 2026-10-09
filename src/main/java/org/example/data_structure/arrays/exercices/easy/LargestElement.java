package org.example.data_structure.arrays.exercices.easy;

import java.util.Arrays;

/**
 * Input:
 *  arr[] = {2, 5, 1, 3, 0}
 * Output:
 *  5
 *
 * arr[] = {8, 10, 5, 7, 9}
 * Output:
 *  10
 */

public class LargestElement {

    public int bruteForce(int[] arr){
        // Sort the array in ascending order in place.
        Arrays.sort(arr);
        return arr[0];
    }


    public int optimaImplementation(int[] arr){
        if (arr.length <= 0) return -1;

        int maximum = arr[0];
        for (int i : arr) {
            if(i > maximum) maximum = i;
        }
        return maximum;
    }
}
