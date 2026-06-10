package org.example.array.exercice.easy;

import java.util.ArrayList;
import java.util.List;

// Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array..
public class MaximumConsecutiveOnes {

    public int brutForce(int[] array){
        int[] output = new int[array.length];
        List<Integer> outputList = new ArrayList<>();

        int index = 0;
        int sum = 0;

        for(int i = 0; i < array.length; i++){
                if(array[i] == 0){
                    outputList.add(sum);
                    output[index] = sum;

                    sum = 0;
                    index++;
                }

                else{
                    sum +=1;
                }
        }
        if(sum != 0){outputList.add(sum); output[index] = sum;}


        var lstMaxValue = getMaxListValue(outputList);
        var arrMaxValue = getMaxArrValue(output);

        return -1;
    }

    public int getMaxListValue(List<Integer> lst){
        int max_value = Integer.MIN_VALUE;

        for(int value : lst){
            if(max_value < value) max_value = value;
        }
        return max_value;
    }
    public int getMaxArrValue(int[] arr){
        int max_value = Integer.MIN_VALUE;

        for(int value : arr){
            max_value = Math.max(max_value, value);
        }
        return max_value;
    }



    public int betterApproach(int[] arr){
        int maxValue = Integer.MIN_VALUE;
        int current = 0;

        for(int val: arr){
            if(val == 1){
                current++;

                if(current > maxValue){maxValue = current;}
            }
            else {
                current = 0;
            }
        }
        return maxValue;
    }
}
