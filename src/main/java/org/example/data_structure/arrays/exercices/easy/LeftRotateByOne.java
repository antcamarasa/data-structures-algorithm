package org.example.data_structure.arrays.exercices.easy;

import java.util.Arrays;

/**
 * Input :
 * nums = [1, 2, 3, 4, 5]
 *
 * Output :
 * nums = [2, 3, 4, 5, 1]
 */

public class LeftRotateByOne {

    public int[] brutForce(int[] arr){
        int elementToInsert = arr[0];

        for (int curr = 0; curr < arr.length - 1; curr++){
            arr[curr] = arr[curr + 1];
        }

        arr[arr.length - 1] = elementToInsert;
        return arr;
    }

    /**
     *
     * Create a dummy array of the same length as the original array.
     * Shift all elements in the original array toward the left, copying them into the dummy array.
     * After shifting, place the value of the 0th index of the original array into the last element of the dummy array.
     * Finally, print the dummy array which now contains the left-shifted elements with the 0th element moved to the last position.
     */
    public int[] brutForceCorrection(int[] arr){
        int[] newArr = new int[arr.length];

        for(int i = 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        newArr[arr.length - 1] = arr[0];

        return newArr;
    };

    public int[] optimalVersion(int[] arr){
        int firstElement = arr[0];

        for (int i = 0; i < arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length - 1] = firstElement;
        System.out.println("Output " + Arrays.toString(arr));
        return arr;
    }
}
