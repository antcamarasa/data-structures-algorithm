package org.example.array.exercice.medium;


import java.util.List;

/**
 * Instruction : Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present int that subarray.
 */
public class maximumSubarraySum {
    record MaxAndParent(int max, int parent, boolean bool){};
    record Myrecord(int max, int parent){}
    // ____________________ BRUT FORCE _____________________
    public int brutForceFirstIteration(int[] arr){
        //List<List<Integer>> positions = new ArrayList<>();
        int maxSubArray = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            int total = Integer.MIN_VALUE;

            for(int j = i; j < arr.length - 1; j++){
                    if(j - i == arr.length - 1){
                        continue;
                    }
                    //List<Integer> current = new ArrayList<>();
                    //fillCurrent(arr, current, i , j);
                    //positions.add(current);

                    total = total == Integer.MIN_VALUE ? arr[j] : total + arr[j];
                    maxSubArray = Math.max(total, maxSubArray);
            }
        }

        //System.out.println("All total value => " + positions);
        return maxSubArray;
    }
    public void fillCurrent(int[] source, List<Integer> list, int startIndex, int endIndex){
        for(int index = startIndex; index< endIndex + 1; index++){
            list.add(source[index]);
        }
    }

    // ____________________ RECURSIVE WAY _____________________
    public void recursive(int[] arr){
        int i = 0;
        int j = i;
        int total = 0;
        int maxSubArraySum = Integer.MIN_VALUE;
        //maxSubArraySum = firstRecursiveVersion(arr, i, j, total, maxSubArraySum);
        //int max = secondRecursive(arr, i, j, 0);
        Myrecord result = fourthVersion(arr, i, j);
        System.out.println(result.max);
    };

    private int firstRecursiveVersion(int[]arr, int i, int j, int total, int maxSubArray){
        // Base case
        if(i == arr.length - 1){
            return maxSubArray;
        }

        int value = Integer.MIN_VALUE;
        if(j - i < arr.length - 1 && j < arr.length - 1){
            total += arr[j];
            value = firstRecursiveVersion(arr, i, j+1, total, Math.max(total, maxSubArray));
        }

        else if (j == arr.length - 1){
         i += 1;
         j = i;
         total = 0;
         value = firstRecursiveVersion(arr, i, j, total, maxSubArray);
        }

        return Math.max(value, maxSubArray);
    }

    private int secondRecursive(int[]arr, int i, int j, int total){
        int max = Integer.MIN_VALUE;
        if( i >= arr.length - 1){
            return arr[j];
        }

        if(j - i < arr.length - 1 && j < arr.length - 1){
            total += arr[j];
            max = Math.max(total, secondRecursive(arr, i, j+1, total));


        }
        else{
            max = Math.max(secondRecursive(arr, i +1,i +1, 0), max);
        }
        return max;
    }
    private MaxAndParent thirdRecursive(int[]arr, int i, int j, boolean canAddToCompare){
        MaxAndParent recordValue = new MaxAndParent(Integer.MIN_VALUE, Integer.MIN_VALUE, false);

        // 0. Cas de base
        if( i >= arr.length - 1){
            int max = Math.max(recordValue.max, arr[j]);
            recordValue = new MaxAndParent(max, arr[j], canAddToCompare);
            return recordValue;
        }

        // 1. Cas ou j est inférieur a la longeur du tableau.
        if(j - i < arr.length - 1 && j < arr.length){
            if(j + 1 >= arr.length || j + 1 - i == arr.length - 1){
                canAddToCompare = false;
            }
            else{
                canAddToCompare = true;
            }

            // Je créer un record courant.
            recordValue = new MaxAndParent(recordValue.max, arr[j], canAddToCompare);

            // Appel récursif
            MaxAndParent returnedRecord = thirdRecursive(arr, i, j+1, canAddToCompare);

            // Ici deux choses sont disponible :
            // 1. L'élément courant
            // 2. L'élément qui vient du retour de l'appel récursif.


            if(canAddToCompare){
                int returnMax = returnedRecord.max;
                int returnParent = returnedRecord.parent;

                int courantMax = recordValue.max;
                int courantParent = recordValue.parent;

                int max = Math.max(returnedRecord.max, returnedRecord.parent + recordValue.parent);

                // Ajout l'élément courant au parent. je sais pas donc a va debogger
                int current_element = recordValue.parent;
                int parent_a_ajouter = returnedRecord.parent;


                int currentMax_1 = max;

                int returnedRecordMAx = returnedRecord.max;

                recordValue = new MaxAndParent(max, recordValue.parent, canAddToCompare);
                System.out.println("OO");

            }
            else{
                int max = Math.max(recordValue.max, returnedRecord.parent);
                recordValue = new MaxAndParent(max, recordValue.parent, canAddToCompare);
            }

        }
        else{
            // Ajouter le bon max value avant de le transmettre.
             MaxAndParent returnedRecord = thirdRecursive(arr, i +1,i +1, canAddToCompare);
             int max = Math.max(recordValue.max, returnedRecord.max);

             // Le parent c'est quoi ?
             recordValue = new MaxAndParent(max, returnedRecord.parent, canAddToCompare);

        }

        return recordValue;
    }

    public boolean isLastInInnerLoop(int[] arr, int i, int j){
        if(j + 1 - i == arr.length - 1  ||  j + 1 == arr.length - 1){
            return true;
        }
        return false;
    }

    boolean checkIfCanAdd(int i, int j, int[] arr){
        // On peut ajouter si : j
        if(j + 1 - i >= arr.length -  1 || j >= arr.length - 1){
            return false;
        }
        return true;
    }

    private Myrecord fourthVersion(int[]arr, int i, int j){
        // Cas de base. i == arr.len(- 1)
           // on retourne la valeur courante et max = arr[j]

        // 1. i et j sont dans la scope et sont inférieur a la taille total du tableau.

        // ------ Avant récursion
        // valeur courante = arr[j]
        // On vérifie si on peut ajouter (canAdd), la règle, si j n'est pas le dernier élément de subArray et si j + 1 - i est pas le dernier éléments de subArray

        // ------ Appel récursif

        // Après récursion
        // A. On peut ajouter
        //    -> max, courant + parent, à valeur max retourné par appel récursif


        // B. On ne peut pas ajouter.
        //    -> max : courant, max.
        //    -> parent => courant.




        // 1. Initialisation
        Myrecord record = new Myrecord(Integer.MIN_VALUE, Integer.MIN_VALUE);

        if(i == arr.length -1){
            return new Myrecord(arr[j], arr[j]);
        }

        // Invariant 1 => j - i < arr.length - 1;
        if(j < arr.length && j - i < arr.length - 1){
            boolean canAdd = checkIfCanAdd(i, j, arr);
            int current = arr[j];

            Myrecord returnedRecord = fourthVersion(arr, i, j + 1);

            if(canAdd){
                int max = Math.max(returnedRecord.max, current + returnedRecord.parent);
                record = new Myrecord(max, current + returnedRecord.parent);
            }
            else{
                int max = Math.max(returnedRecord.max, current);
                record = new Myrecord(max, current);
            }

        }

        else{
            // courant  = 5;
            // SKIP !
            Myrecord returnedRecord = fourthVersion(arr, i + 1, i +1);

            // Ici si le parent = dernier élément du sous tableau ou bien le tout premier.
            // Si ce tout premier élement est plus grand que l'addition des autres éléments alors il devient le maximum.
            // C'est le case avec -4 + 7 = 3 => 7 devient le nouveau parent, 7 > addition de 7 + - 4 donc le nouveau max est 7.
            int max = Math.max(returnedRecord.max, returnedRecord.parent);
            record =new Myrecord(max, -1);
        }

        return record;
    }

    // _________________ Correction ___________________________
    private Myrecord fourthVersionCorrection(int[]arr, int i, int j){
        Myrecord rec = new Myrecord(Integer.MIN_VALUE, Integer.MIN_VALUE);
        int n = arr.length;

        if(i >= n){
            boolean canAdd = j < n -1;
            return new Myrecord(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        if(j >= n){
            return fourthVersion(arr, i + 1, i + 1);
        }
        return rec;
    }

    // ________________ Kadane's Algorithm  ___________________
    public void kadanesAlgorithm(int[] arr){

    };
}
