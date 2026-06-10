package org.example.array.exercice.easy;

import java.util.*;

public class FindTheNumbersThatAppearsOne {

    public int solveUsingHashWithArray(int[] arr){
        int result = -1;

        if(arr.length == 0){
            // Throw exception
            System.out.println("La longeur du tableau est inférieur à 0");
            return -1;
        }

        // 1. Get max value (for create a array with the length of max value element)
        int maxValue = arr[0];
        for(int i = 1; i < arr.length; i++){
            maxValue = Math.max(maxValue, arr[i]);
        }

        // 2. hashArray : index = element, valeur a l'index  = nbr occurence.
        int[] hashArray = new int[maxValue + 1];

        for(int i = 0; i < arr.length; i++){
            hashArray[arr[i]] += 1;
        }
        // 3. On retourne l'index du tableau qui contient 1.
        for(int i = 0; i < hashArray.length; i++){
            if(hashArray[i] == 1){
                result = i;
            }
        }

        return result;
    }


    public void solveUsingHashWithArraySecond(int[] arr){
        int maxValue = Integer.MIN_VALUE;
        Set<Integer> uniqueArValues = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                maxValue = arr[0];
                uniqueArValues.add(arr[0]);
                continue;
            }
            maxValue = Math.max(maxValue, arr[i]);
        }

        int[] hashArray = new int[maxValue + 1];
        for(int i = 0; i < arr.length; i++){
            hashArray[arr[i]] += 1;
            if(hashArray[arr[i]] > 1){
                uniqueArValues.remove(hashArray[arr[i]]);
            }
        }

        System.out.println("unique values " + uniqueArValues);
    }




    public int solveUsingHashingFirst(int[] arr){
        Map<Integer, Integer> count = new HashMap<>();
        for(int el : arr){
            count.put(el, count.getOrDefault(el, 0) + 1);
        }
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(entry.getValue() == 1){result = entry.getKey(); break;}
        }
        return result;
    }

    public int solveUsingHashing(int[] arr){
        Set<Integer> uniqueValue = new HashSet<>();

        Map<Integer, Integer> count = new HashMap<>();
        for(int el : arr){
            if(count.containsKey(el)){
                uniqueValue.remove(el);
            }
            else {
                uniqueValue.add(el);
                count.put(el, 0);
            }
        }
        
        int value = 0;
        if(uniqueValue.size() == 1){
            for(int val : uniqueValue){
                value = val;
            }
        }
        return value;
    }
}
