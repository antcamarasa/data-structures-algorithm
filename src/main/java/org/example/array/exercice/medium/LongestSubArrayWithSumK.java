package org.example.array.exercice.medium;

import java.util.*;

public class LongestSubArrayWithSumK {

    public int firstImplementation(int[] arr, int k){
        int output = Integer.MIN_VALUE;
        int n = arr.length;

        int left = 0;
        int right = 0;


        int total = 0;
        while(right < n){
            total += arr[right];
            if(total > k){
                while (left <= right){
                    total -= arr[left];
                    left++;
                }
            }

            if (total == k){
                output = Math.max(output, (right - left) + 1);
            }

            right++;
        }
        if(output > 0){ return output;}
        return -1;
    }
    public int findSumOfAllSubArray(int [] arr, int k){
        // probleme => je ne peux pas avoir de clé duppliquer.
        //record Tuple(int len, int total){};
        //Map<Integer, Tuple> map = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        SortedSet<Integer> tree = new TreeSet<>();

        int key = 0;
        for(int i = 0; i < arr.length; i++){
            int total = 0;
            int len = 0;

            for(int j = i; j < arr.length; j++){
                if(i == j){
                    total += arr[i];
                    if(total == k){
                        lst.add((j - i) + 1);
                        tree.add((j - i) + 1);
                    }

                    //map.put(key, new Tuple(j - i + 1, total));
                    // key++;
                    continue;
                }
                total += arr[j];
                if(total == k){
                    lst.add((j - i) + 1);
                    tree.add((j - i) + 1);
                }
                //map.put(key, new Tuple(j - i + 1, total));
                //key++;
            }
        }
        System.out.println("lst" + lst);

        // Ici l'idée est de venir récupérer l'élément le plus grand, plusieurs options :
        // 1. Classique faire une boucle linéaire et récupérer le plus grand.
        int max = lst.getFirst();
        for(int el : lst){
            max = Math.max(max, el);
        }
        System.out.println("Max : " + max);


        // 2. Trié ma liste récupérer le premier.
        lst.sort(null);
        lst.getLast();

        // 2.1 Comment faire l'inverse ?? A creuser.
        // Compare => me retourne un nombre
        // < 0 => a, avant b
        // = 0 => a et b equivalent
        // > 0 => a, après b
        lst.sort((a, b) -> {
            if (a > b) return -1;
            else if (a < b) return 1;
            else return 0;
        });
        int rs = lst.getFirst();
        System.out.println("rs :" + rs);

        // 3. Utilisé un arbre équilibré car tout est trié donc premier ou dernier element = plus grand.
        System.out.println("Tree : " + tree );
        System.out.println("first : " + tree.getFirst());
        System.out.println("last : " + tree.getLast());

        // 4. Utilisé un Tas(Heap)/priorityQueue qui garanti que le premier élément est toujours soit plus grand soit plut petit. Le reste n'est pas totalement triée.

        return -1;
    }

    public int twoPointerCorrection(int[] arr, int k){
        int n = arr.length;

        int maxLen = Integer.MIN_VALUE;

        // Set up : two pointers
        int left = 0;
        int right = 0;

        // Total = actual window
        int total = arr[left];

        while (right < n) {
            while(total > k && left <= right){
                total -= arr[left];
                left++;
            }

            if(total == k){
                maxLen = Math.max(maxLen, (right - left) + 1);
            }

            right++;
            if(right < n){
                total += arr[right];
            }
        }

        return maxLen;
    }

}
