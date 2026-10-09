package org.example.data_structure.fundamental.arrays.exercices.easy;

import java.util.HashSet;
import java.util.Set;

/**
 *  Problem : En fonction d'un entier N et d'un tableau de taille N - 1 contenant des nombres entre 1 à N.
 *            Trouvé le nombre(entre 1 et N) qui n'est pas présent dans le tableau donnée.
 *
 *  Exemple 1 :
 *  Input -> N = 5, array[] = {1, 2, 4, 5}, result = 3
 *  3 est le nombre manquant de la suite.
 *
 *  Exemple 2 :
 *  N = 3, array[] = {1, 3}, result = 2
 */
public class FindTheMissingNumberInArray {
    public int bruteForce(int n, int[] arr){
        // 1. On crée un tableau contenant toutes les valeurs possibles.
        int[] refs = new int[n];
        for(int i = 0; i < n; i++){
            refs[i] = i + 1;
        }

        // 2. On trouve la valeur manquantes
        for(int ref : refs){
            boolean find = false;

            for(int arrElement : arr){
                if(arrElement == ref){
                    find = true;
                    break;
                }
            }
            if (!find) return ref;
        }
        return -1;
    }
    public int betterApproach(int n, int[] arr){
        Set<Integer> mySet = new HashSet<>();
        Set<Integer> arrSet = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(i < arr.length){
                arrSet.add(arr[i]);
            }
            mySet.add(i + 1);
        }

        System.out.println("Array to set => "    + arrSet);
        System.out.println("Array reference => " + mySet);

        mySet.removeAll(arrSet);
        System.out.println("My set > " + mySet);

        return -1;
    }

    // Correction
    // Linear Search

    public int linearSearch(int n, int[] arr){
        for (int i = 1; i <= n; i++){
            boolean found = false;
            for(int element : arr){
                if(element == i){found = true; break;}
            }
            if(!found){
                return i;
            }
        }
        return -1;
    }
    public int optimizedApproach(int n, int[] arr){
        return -1;
    }
}
