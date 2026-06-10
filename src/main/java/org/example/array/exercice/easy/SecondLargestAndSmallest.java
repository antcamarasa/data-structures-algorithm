package org.example.array.exercice.easy;

public class SecondLargestAndSmallest {

    public Integer brutForceSecondMinium(int[] arr){
        if(arr.length <= 1) return -1;

        int minimum = arr[0];
        Integer secondMinimum = null;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < minimum){
                secondMinimum = minimum;
                minimum = arr[i];
            }
            else {
                if(secondMinimum == null){
                    secondMinimum = arr[i];
                }
                else if(arr[i] < secondMinimum){
                    secondMinimum = arr[i];
                }
            }
        }
        return secondMinimum;
    }
    public Integer brutForceSecondMaximum(int[] arr){
        if(arr.length <= 1) return -1;

        int maximum = arr[0];
        int secondMaximum = -1;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > maximum){
                secondMaximum = maximum;
                maximum = arr[i];
            }
            else if (arr[i] > secondMaximum && arr[i] != maximum){
                    secondMaximum = arr[i];
            }
        }
        return secondMaximum;
    }


    public int[] betterSolution(int[] arr){
        int[] output = new int[2];

        int minium = Integer.MAX_VALUE, secondMinimum  = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE, secondMaximum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < minium){
                secondMinimum = minium;
                minium = arr[i];
            } else if (arr[i] < secondMinimum && arr[i] != minium) {
                secondMinimum = arr[i];
            }

            if(arr[i] > maximum){
                secondMaximum = maximum;
                maximum = arr[i];
            } else if (arr[i] > secondMaximum) {
                secondMaximum = arr[i];
            }
        }

        return new int[]{secondMinimum, secondMaximum};
    }
}
