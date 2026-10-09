package org.example.data_structure.map.exercices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingWordFrequency {
    /**
     * TODO => Code review a faire.
     * Return un map of Word : Frequency
     */
    public Map<String, Integer> wordFrequencyCount(String docs){
        Map<String, Integer> frequencyCountMap = new HashMap<>();

        String[] myArrayOfString = docs.split(" ");
        // boolean containsKey(Object key);
        for(String str : myArrayOfString){
            if(frequencyCountMap.containsKey(str.toLowerCase())){
                frequencyCountMap.put(str, frequencyCountMap.get(str) + 1);
                continue;
            }
            frequencyCountMap.put(str, 1);
        }

        return frequencyCountMap;
    }

    public Map<String, Integer> getMaxOccurence(Map<String, Integer> frequencyCountMap){
        Map<String, Integer> maxOccurence = new HashMap<>();

        for(Map.Entry<String, Integer> entries : frequencyCountMap.entrySet()){
            if(maxOccurence.isEmpty()){
                maxOccurence.put(entries.getKey(), entries.getValue());
                continue;
            }

            String oldKey;
            Integer oldValue;

            for(Map.Entry<String, Integer> previous : maxOccurence.entrySet()){
                oldKey = previous.getKey();
                oldValue = previous.getValue();
                if(oldValue >= entries.getValue()){
                    break;
                };

                maxOccurence.remove(oldKey);
                maxOccurence.put(entries.getKey(), entries.getValue());
            }
        }

        return maxOccurence;
    }
}
