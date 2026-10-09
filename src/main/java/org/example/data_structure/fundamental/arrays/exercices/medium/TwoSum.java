package org.example.data_structure.fundamental.arrays.exercices.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   Instructions : Given an array of integers arr[] and an integer target
 *   1st variant => Return true if there exist two numbs such that their sum is equal to target, return No.
 *
 *   Explications :
 *   Dans l'algorithme brutForce, les deux boucles font exactement :
 *   - Pour chaque element arr[i] comparer arr[i] avec tous les éléments restant pour voir si une somme vaut target.
 *     On test tous les couples possibles [i, j].
 *
 *   Dans la version optimisé on supprime une des deux boucles grace a une table de hash et ces performances de recherches O(1) sur les clés.
 *   - Pour qu'un couple (a, b) = target => a + b = target | b = target - a;
 *   Donc au lieu de chercher b par comparaison, on peux le calculer directement.
 *
 *   Le hashMap, représente la mémoire de ce que l'on a déja vu :
 *   - a est vu -> Stocké
 *   - b arrive -> target - b est présent dans hashMap alors on retourne true.
 *
 *   Tout couple valide (a, b) est forcément trouvé quand le second arrive.
 */
public class TwoSum {
    // Brut Force
    public boolean firstVariantBrutForce(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // Business logic
                if (arr[i] + arr[j] == target) return true;
            }
        }
        return false;
    }

    // Better Approach
    public int[] betterApproachSecondVariant(int[] arr, int taget) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int searchValue = taget - arr[i];
            if (seen.containsKey(searchValue)) return new int[]{seen.get(searchValue), i};
            seen.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }


    // Optimal. greedy

    /**
     * Dans cette approche, nous allons d’abord trier le tableau, puis essayer de choisir les nombres de manière gloutonne.
     * Nous plaçons un pointeur left au premier indice et un pointeur right au dernier indice. Tant que left < right, nous calculons la somme de arr[left] et arr[right].
     * Si la somme est inférieure à la cible, nous avons besoin de nombres plus grands, donc nous incrémentons le pointeur left.
     * Si la somme est supérieure à la cible, nous devons considérer des nombres plus petits, donc nous décrémentons le pointeur right.
     * Si la somme est égale à la cible, nous retournons soit "YES", soit les indices, selon l’énoncé.
     * Si le pointeur left dépasse le pointeur right, cela signifie qu’aucune paire valide n’existe, et nous retournons "NO" ou {-1, -1}.
     */
    public boolean optimal(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int result = arr[left] + arr[right];
            System.out.println(result);

            if(result == target) return true;
            else if (result > target) {
                right--;
                continue;
            }
            left++;
        }
        return false;
    }
}
