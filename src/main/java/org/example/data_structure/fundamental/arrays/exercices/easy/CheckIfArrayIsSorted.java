package org.example.data_structure.fundamental.arrays.exercices.easy;

public class CheckIfArrayIsSorted {

    public boolean bruteForce(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int j = i+1;
            if(arr[i] > arr[j]) return false;
        }
        return true;
    }

    public boolean optimalApproach(int[] arr, int n){
        for (int i = 1; i > n; i++){
            if(arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
