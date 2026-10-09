package org.example.algorithms.backtracking.exercices;

import java.util.*;

/**
 * Problem statement : Given n pairs of parentheses, write a function to generate all combinations of well-formed parenthesis.
 * input  => n = 3; // Signifie () * 3;
 * output => [ "((()))", "(()())", "(())()", "()(())", "()()()"]
 */

public class GenerateParenthesis {
    private final String OPEN  = "(";
    private final String CLOSE = ")";
    List<String> allPossibleValues = new ArrayList<>();
    Set<String> allUniqueValue = new HashSet<>();

    // Brut Force
    public Set<String> brutForce(int n){
        List<String> tmp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tmp.add(OPEN);
        }
        for(int i = 0; i < n; i++){
            tmp.add(CLOSE);
        }

        allUniqueValue.add(String.join("", new ArrayList<>(tmp)));
        int len = n * 2;

        for(int i = 0; i < len; i++){
            int curr = 1;

            while(curr + 1 < tmp.size()){
                // Je récupère la valeur +1
                String temporary = tmp.get(curr + 1);

                // je swap index, nouvelle valeur
                tmp.set(curr + 1, tmp.get(curr));
                tmp.set(curr, temporary);

                checkAndAdd(new ArrayList<>(tmp));
                curr++;
            }
        }
        return  allUniqueValue;
    }
    public void checkAndAdd(List<String> lst){
        if(!Objects.equals(lst.getLast(), OPEN)){

            int openCount = 0;
            int closeCount = 0;

            for(String el : lst){
                if(Objects.equals(el, OPEN)) openCount++;
                else closeCount++;

                if(Objects.equals(el, CLOSE) && openCount < closeCount){
                    return;
                }
            }
            allUniqueValue.add(String.join("", lst));
        }
    }

    // Recursive
    public List<String> firstIteration(int n){
        helperRecursive(new ArrayList<>(), n, OPEN);
        return allPossibleValues;
    }
    private void helperRecursive(List<String> tmp, int n, String str){
        // 1. Ajout de str dans tmp.
        //    tmp .isempty => add
        //    otherwise we can add only if Open are > than Close
        tmp = new ArrayList<>(tmp);
        if(Objects.equals(str, OPEN)) tmp.add(str);
        else {
            int close = 0;
            int open = 0;
            for(String element : tmp){
                if(Objects.equals(element, OPEN)) {
                    open++;
                }
                else close++;
            }

            if(open > close){
                tmp.add(str);
            }
            else{
                return;
            }
        }

        // 2. Base case
        // On compte les occurences de open, si == n on stop et on retourne.
        //int counter = Collections.frequency(tmp, OPEN);

        //long count = tmp.stream()
        //        .filter(s -> Objects.equals(s, OPEN))
        //        .count();


        int counter = 0;
        for(String element : tmp){
            if(Objects.equals(element, OPEN)){
                counter++;
            }
        }

        if(counter == n){
            while (tmp.size() < 2 * n){
                tmp.add(CLOSE);
            }
            allPossibleValues.add(String.join("", tmp));
            return;
        }


        helperRecursive(tmp, n, OPEN);
        helperRecursive(tmp, n, CLOSE);
    }


    // Correction, brutForce(recursive).
    public boolean isValid(String str){
        int balance = 0;
        for(char c : str.toCharArray()){
            if(c == '('){
              balance++;
            }
            else balance --;
            if(balance < 0) return false;
        }
        return balance == 0;
    }
    public void helperRecursive(String str, List<String> output, int n){
        if(str.length() == n * 2){
            if(isValid(str)) output.add(str);
            return;
        }

        helperRecursive(str + "(", output, n);
        helperRecursive(str + ")", output, n);
    }
    public List<String> generateParenthesis(int n){
        List<String> parenthesis = new ArrayList<>();
        helperRecursive("", parenthesis, n);
        return parenthesis;
    }

    // Brut force other option
    public List<List<Integer>> brutForceOther(int n){
        List<List<Integer>> output = new ArrayList<>();

        // 1. Construit nos pointeurs.
        int pointersSize   = n - 1;
        int expressionSize = n * 2;

        List<Integer> pointers = new ArrayList<>();
        for(int i = 1; i < n; i++){
            pointers.add(i);
        }

        while(true){
            int current = pointers.getLast();
            int currentIdx = pointers.indexOf(current);

            while(current <= getLastPosition(expressionSize, pointers, n - 1)){
                output.add(new ArrayList<>(pointers));
                current++;
                pointers.set(currentIdx, current);
            }

            while(current >= getLastPosition(expressionSize, pointers, n - 1)){ // 8, List [1, 6], 6
                if(pointers.size() == 1) return output;
                pointers.removeLast();
                current = pointers.getLast();
            }

            pointers.set(pointers.indexOf(pointers.getLast()), pointers.getLast() +1);
            current = pointers.getLast(); // Update current.
            int next = current;
            while(pointers.size() < pointersSize){
                next++;
                pointers.add(next);
            }
        }
    }


    public int getLastPosition(int expressions, List<Integer> pointers, int n){
        return  expressions - 1 - (n - pointers.size());
    }


    public List<String> putItTogether(List<List<Integer>> allCombinaison, int n){
        List<String> all = new ArrayList<>();
        String[] combinaison;
        String open  = "(";
        String close = ")";

        for(List<Integer> lst : allCombinaison){
            combinaison = new String[n*2];
            for(int i = 0; i < combinaison.length; i++){
                if(i == 0) combinaison[0] = open;
                else{
                    if(lst.contains(i)) combinaison[i] = open;
                    else combinaison[i] = close;
                }
            }

            String assemblee = String.join("", combinaison);
            if(isValid(assemblee)) all.add(assemblee);
        }
        return all;
    }
    public void displayOutput(List<List<Integer>> output){
        for(List<Integer> lst : output){
            for(Integer element : lst){
                System.out.print(element + ", ");
            }
            System.out.println();
        }
    }



    // Correction version iterative :
    // 1. Combination pure
    // 2. Next Permutation

    /**
     * public class ParensIterativeGenerators {
     *
     *     // ---------------------------
     *     // Version 1: "Positions of opens" (combinations of indices)
     *     // ---------------------------
     *     public static Set<String> generateByOpenPositions(int n) {
     *         if (n < 0) throw new IllegalArgumentException("n must be >= 0");
     *         int L = 2 * n;
     *
     *         Set<String> out = new LinkedHashSet<>();
     *         if (n == 0) {
     *             out.add("");
     *             return out;
     *         }
     *
     *         // pos[k] = index of the k-th '(' in increasing order
     *         int[] pos = new int[n];
     *         for (int i = 0; i < n; i++) pos[i] = i; // [0,1,2,...,n-1]
     *
     *         while (true) {
     *             // Build string from positions
     *             char[] s = new char[L];
     *             Arrays.fill(s, ')');
     *             for (int p : pos) s[p] = '(';
     *             out.add(new String(s));
     *
     *             // Next combination of indices
     *             int i = n - 1;
     *             // Find rightmost i that can be incremented
     *             // Max for pos[i] is L - (n - i)
     *             while (i >= 0 && pos[i] == L - (n - i)) i--;
     *             if (i < 0) break; // finished
     *
     *             pos[i]++; // increment this position
     *             // reset the suffix to minimal increasing sequence
     *             for (int k = i + 1; k < n; k++) {
     *                 pos[k] = pos[k - 1] + 1;
     *             }
     *         }
     *
     *         return out;
     *     }
     *
     *     // ---------------------------
     *     // Version 2: "Next permutation" on multiset of '(' and ')'
     *     // ---------------------------
     *     public static Set<String> generateByNextPermutation(int n) {
     *         if (n < 0) throw new IllegalArgumentException("n must be >= 0");
     *
     *         Set<String> out = new LinkedHashSet<>();
     *         if (n == 0) {
     *             out.add("");
     *             return out;
     *         }
     *
     *         // Start from lexicographically smallest arrangement for '(' < ')'
     *         // i.e. "((...()))...".
     *         char[] a = new char[2 * n];
     *         for (int i = 0; i < n; i++) a[i] = '(';
     *         for (int i = n; i < 2 * n; i++) a[i] = ')';
     *
     *         while (true) {
     *             out.add(new String(a));
     *             if (!nextPermutation(a)) break;
     *         }
     *
     *         return out;
     *     }
     *
     *     Standard lexicographic next permutation for char[].
     *     Returns false if already at the last permutation.
     *
     *     private static boolean nextPermutation(char[] a) {
     *         int i = a.length - 2;
     *         while (i >= 0 && a[i] >= a[i + 1]) i--;
     *         if (i < 0) return false;
     *
     *         int j = a.length - 1;
     *         while (a[j] <= a[i]) j--;
     *
     *         swap(a, i, j);
     *         reverse(a, i + 1, a.length - 1);
     *         return true;
     *     }
     *
     *     private static void swap(char[] a, int i, int j) {
     *         char t = a[i];
     *         a[i] = a[j];
     *         a[j] = t;
     *     }
     *
     *     private static void reverse(char[] a, int l, int r) {
     *         while (l < r) swap(a, l++, r--);
     *     }
     *
     *     // ---------------------------
     *     // Optional: filter only VALID parentheses (still iterative)
     *     // ---------------------------
     *     public static boolean isValidParens(String s) {
     *         int bal = 0;
     *         for (int k = 0; k < s.length(); k++) {
     *             char c = s.charAt(k);
     *             if (c == '(') bal++;
     *             else bal--;
     *             if (bal < 0) return false;
     *         }
     *         return bal == 0;
     *     }
     *
     *     public static Set<String> filterValid(Set<String> all) {
     *         Set<String> out = new LinkedHashSet<>();
     *         for (String s : all) {
     *             if (isValidParens(s)) out.add(s);
     *         }
     *         return out;
     *     }
     *
     *     // Demo
     *     public static void main(String[] args) {
     *         int n = 3;
     *
     *         Set<String> a = generateByOpenPositions(n);
     *         Set<String> b = generateByNextPermutation(n);
     *
     *         System.out.println("By open positions (count=" + a.size() + "): " + a);
     *         System.out.println("By next permutation (count=" + b.size() + "): " + b);
     *
     *         System.out.println("Valid only: " + filterValid(b));
     *     }
     * }
     */
}
