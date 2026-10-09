package org.example.data_structure.arrays.exercices.medium;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
    public int solvedUsingSet(int[] input){
        Set<Integer> unique = new HashSet<>();
        for(int el : input){
            if(!unique.contains(el))
                unique.add(el);
            else
                return el;
        }
        return -1;
    }
    public int solveWithoutAllocation(int[] input) {
        for(int i = 0; i < input.length -1; i++){
            for(int j = i+1; j< input.length; j++){
                if(input[i] == input[j])return input[i];
            }
        }
        return -1;
    }


    public boolean hasCycle(int[] input){
        int slow = 0;
        int fast = 0;

        while (true){
            slow = input[slow];
            fast = input[input[fast]];

            if(fast == slow)
                return true;
        }
    }
}
