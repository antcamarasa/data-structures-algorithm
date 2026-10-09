package org.example.data_structure.fundamental.arrays.exercices.easy;

import java.util.*;

public class SetOperationUsingArray {

    // =================================== UNION ====================================
    // Valeur présentes dans 1 et 2 => Non dupliquées.
    // Using Set(valeur uniques seulement)
    public Set<Integer> unionUsingSet(int[] arr, int[] arr_1){
        Set<Integer> union = new HashSet<>();
        int[] newArr = new int[arr.length + arr_1.length];
        for (int i = 0; i < newArr.length; i++) {
            if(i < arr.length){
                union.add(arr[i]);
              newArr[i] = arr[i];
              continue;
            }
            union.add(arr_1[i - arr.length]);
            newArr[i] = arr_1[i - arr.length];
        }

        return union;
    }


    // Using Map(compter les occurences)
    // Les maps, permettent de mapper deux valeurs ensembles. Utile pour compter les occurences d'une string, d'un chiffre...
    public int[] unionUsingMap(int[] arr, int[] arr_2){
        Map<Integer, Integer> nbrOfOccurences = new HashMap<>();

        for (int j : arr) nbrOfOccurences.put(j, nbrOfOccurences.getOrDefault(j, 0) + 1);
        for (int i : arr_2) nbrOfOccurences.put(i, nbrOfOccurences.getOrDefault(i, 0) + 1);

        // On ne garde que les clés.
        int[] unionValue = new int[nbrOfOccurences.size()];
        int index = 0;
        for(int key : nbrOfOccurences.keySet()){
            unionValue[index] = key;
            index++;
        }

        return unionValue;
    }


    // ================================= TWO POINTERS ===============================
    public void fillUniqueValue(int[] arr, List<Integer> values){
        for(int i = 0; i < arr.length; i++){
            int pointerArr = arr[i];
            if(values.isEmpty()){values.add(pointerArr); continue;}

            for(int pointerValues: values){
                if (pointerArr == pointerValues) return;
            }
            values.add(pointerArr);
        }
    }
    public void twoPointer(int[] arr, int[] arr_2){
        // Idée général => 1 pointeur sur la liste, 1 pointeur sur destination.
        List<Integer> union = new ArrayList<>();
        fillUniqueValue(arr, union);
        fillUniqueValue(arr_2, union);
        System.out.println("Unique value => " + union);

    }

    public List<Integer> twoPointerSecondVersion(int[]arr, int[] arr_2){
        // Idée général : Comme les listes sont trié on compare on ajoute le plus petit si pas présent dans output et on incrémente.
        List<Integer> out = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < arr.length && j < arr_2.length){
            if(arr[i] < arr_2[j] && !out.contains(arr[i])){
                if(!out.contains(arr[i])){out.add(arr[i]);}
                i++;
            }
            else if (arr[i] < arr_2[j]){
                j++;
                if(!out.contains(arr_2[j])){out.add(arr_2[j]);}
            }
            else{
                if(!out.contains(arr[i])){out.add(arr[i]);}
                i++;
                j++;
            }
        }

        if(i < arr.length){
            while(i < arr.length){
                if(!out.contains(arr[i])){out.add(arr[i]);}
                i++;
            }
        } else if (j < arr_2.length) {
            while (j < arr_2.length){
                if(!out.contains(arr_2[j])){out.add(arr_2[j]);}
                j++;
            }
        }
        System.out.println("Out > " + out);
        return out;
    }

    public void fillValue(int index, int[] arr, List<Integer> out){
        for(int i = index; i < arr.length; i++){
            if(!out.contains(arr[i])){out.add(arr[i]);}
        }
    }
    public void twoPointerRecursive(int[] arr, int[] arr_2, List<Integer> out, int i, int j){
        if(i >= arr.length || j >= arr_2.length){
            if(i < arr.length) fillValue(i, arr, out);
            else fillValue(j, arr_2, out);
            return;
        }

        if(arr[i] < arr_2[j]){
            if(!out.contains(arr[i])){ out.add(arr[i]);}
            i++;
            twoPointerRecursive(arr, arr_2, out, i, j);
        }
        else if (arr[i] > arr_2[j]){
            if(!out.contains(arr_2[j])){ out.add(arr_2[j]);}
            j++;
            twoPointerRecursive(arr, arr_2, out, i, j);
        }
        else {
            if(!out.contains(arr[i])){ out.add(arr[i]);}
            i++;
            j++;
            twoPointerRecursive(arr, arr_2, out, i, j);
        }
    }

    public void twoPointerCorrection(int[] arr1, int[] arr2){
        int n = 0;
        int m = 0;
        List<Integer> out = new ArrayList<>();

        while(n < arr1.length && m < arr2.length){
            if(arr1[n] < arr2[m]){
                if(out.isEmpty() || out.getLast() != arr1[n]){
                    out.add(arr1[n]);
                }
                n++;

            } else if (arr1[n] > arr2[m]) {
                if(out.isEmpty() || out.getLast() != arr2[m]){
                    out.add(arr2[m]);
                }
                m++;
            }

            else{
                if(out.isEmpty() || arr1[n] != out.getLast()){
                    out.add(arr1[n]);
                }
                n++; m++;
            }
        }

        while(n < arr1.length){
            if(out.isEmpty() || arr1[n] != out.getLast())
                out.add(arr1[n]);
            n++;
        }

        while(m < arr2.length){
            if(out.isEmpty() || arr2[m] != out.getLast())
                out.add(arr2[m]);
            m++;
        }


        System.out.println("out : " + out);
    }
}
