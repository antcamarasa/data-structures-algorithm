package org.example.data_structure.fundamental.arrays.exercices.easy;

import java.util.*;

public class removeDuplicateInPlace {

    public void brutForce(String[] arr){
        HashSet<String> seen = new HashSet<String>();
        Queue<Integer> queueIndex = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++){
            // Déja vu, donc pas d'ajout.
            if(!seen.contains(arr[i])){
                // Ajoute dans les vues.
                seen.add(arr[i]);
                // Si des elements on été supprimé
                if(!queueIndex.isEmpty()){
                    int firstIndexInserted = queueIndex.poll();
                    arr[firstIndexInserted] = arr[i];
                    arr[i] = "_";
                    queueIndex.add(i);
                }
            }
            else{
                arr[i] = "_";
                queueIndex.add(i);
            }
        }
    };

    public int bruteForceCorrection(String[] arr){
        HashSet<String> unique = new HashSet<>();
        int index = 0;

        for(String element: arr){
            if(!unique.contains(element)){
                unique.add(element);
                arr[index] = element;
                index++;
            }
        }

        for(int i = index; i <arr.length; i++){
            arr[i] = "_";
        }

        return index;
    }

    /**
     *
     * D'après mon input / output cet exercice est identique a la logique du :
     * -> "Move 0 at the end"
     *
     * Pour aider je créer un HashSet, stock uniquement des valeurs unique.
     * Ensuite je boucle sur chaque item de mon tableau :
     * 1. Si absent de mon hashSet alors je l'ajoute a ce dernier et continue.
     * 2. Si présent =>
     *        - Je déplace tous les éléments de mon tableau vers la gauche et remplace le dernier par "_" (identique a move zero).
     *        - Après déplacement  : si la nouvelle valeurs a la position i est toujours pas unique, je continue cette opération.
     *        - Quand je sort de mon while : Je suis sur que ma valeur est pas présente dans seen, donc je l'ajoute.
     */
    public String[] secondVersion(String[] arr){
        HashSet<String> seen = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            if("_".equals(arr[i])){
                return arr;
            }

            if(seen.contains(arr[i])){
                while(seen.contains(arr[i])){
                    if("_".equals(arr[i])) return arr;

                    for(int current = i; current < arr.length - 1; current++){
                        arr[current] = arr[current++];
                    }
                    arr[arr.length - 1] = "_";

                    if("_".equals(arr[i])){
                        return arr;
                    }
                }
            }
            seen.add(arr[i]);
        }
        return arr;
    }


    public String[] optimalMyVersion(String[] arr){
        int indexOfLastElement = 0;
        for (int i = 0; i < arr.length -1; i++) {
            int j = i+1;

            if(Objects.equals(arr[i], arr[j])){
                int indexToInsert = j;
                while(j < arr.length && Objects.equals(arr[i], arr[j])){
                    j++;
                }

                if (j == arr.length) break;
                arr[indexToInsert] = arr[j];
            }
            indexOfLastElement = j + 1;
        }

        for(int lstIdx = indexOfLastElement; lstIdx < arr.length; lstIdx++){
            arr[lstIdx] = "_";
        }
        return arr;
    }

    public String[] optimal(String[] arr){
        // If array is empty, return 0
        if (arr.length == 0) return arr;

        // Pointer for last unique element
        int i = 0;

        for (int j = 1; j < arr.length; j++){
            // Start from second element
            if(arr[i] != arr[j]){
                // Move unique position forward
                i++;
                // Place new unique element
                arr[i] = arr[j];
            }
        }

        for(int lstIdx = i+1; lstIdx < arr.length; lstIdx++){
            arr[lstIdx] = "_";
        }
        return arr;

    }
}
