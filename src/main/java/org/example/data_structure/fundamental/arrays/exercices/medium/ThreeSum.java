package org.example.data_structure.fundamental.arrays.exercices.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {


    // DEPRECATED
    public boolean threeSumEasier(int[] arr, int target) {
        Map<String, Map<Integer, Integer>> seen = new HashMap<>();
        seen.put("values", new HashMap<>());

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int index = i;
            int search = target - value;

            if (seen.get("values").size() < 2) {
                // TODO : Gestion des doublons.
                if (!seen.containsKey(value)) {
                    seen.get("values").put(value, 0);
                }
            }
            else {
                List<Integer> myList = new ArrayList<>();

                // 1. On crée une liste pour pouvoir itérer :
                Map<Integer, Integer> values = seen.get("values");
                for(Map.Entry<Integer, Integer> element : values.entrySet()){
                    myList.add(element.getKey());
                }

                //1. On cherche si i + j == search si oui on return true, sinon on ajoute value à arr
                for(int x = 0; x < myList.size() - 1; x++){
                    for(int j = x + 1; j < myList.size(); j++){
                        if(myList.get(x) + myList.get(j) == search) return true;
                    }
                }
                seen.get("values").put(value, 0);
            }
        }
        return false;
    }
    public boolean threeSum(int[] arr, int target) {
        int[] arrCopy = new int[arr.length];

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] >target){continue;}
            int current = arr[i];

            Map<Integer, Integer> seen = new HashMap<>();
            for(int j = i +1; j < arr.length; j++){
                int scopeTotal = current + arr[j];

                // Early return
                if(scopeTotal > target){continue;}
                int searchValue = target - scopeTotal;

                if(seen.isEmpty()){
                    seen.put(arr[j], j);}
                else if(seen.containsKey(searchValue)){
                    return true;
                }
                else{
                    seen.put(arr[j], j);
                }
            }

        }
        return false;
    }
}
