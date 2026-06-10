package org.example.backtracking.Combinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Instruction : You are given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * Exemple : input n = 3, k = 2
 * k = 2 donc 2 element maximum entre 1, 2 et 3 => [[1, 2], [1, 3], [2, 3]]
 */
public class Combinations {
    // BrutForce
    public Set<List<Integer>> brutForce(int n, int k){
        Set<List<Integer>> output = new HashSet<>();

        // Can use a set for none duplicate ?
        List<Integer> possibleValues = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            possibleValues.add(i);
        }

        List<Integer> pointers = new ArrayList<>();
        for(int ptrs = 0; ptrs < k; ptrs++){
            pointers.add(ptrs);
        }

        while(true) {
            // 1. Add la liste courante, pointers = index de possibleValues.
            List<Integer> tmp = new ArrayList<>();
            for (int idx : pointers) {
                tmp.add(possibleValues.get(idx));
            }

            // 2. On ajoute la sous-liste à output.
            output.add(tmp);

            // 3. Si pointers non vide && que l'on peut incrémenter le dernier pointers alors on s'arrête.
            while (!pointers.isEmpty() && !canIncrementLastPointers(pointers, possibleValues, k)) {
                pointers.removeLast();
            }

            // 4. if pointers.isEmpty, alors la fonction est temriné.
            if(pointers.isEmpty()) return output;

            // 4. Ici on incrémente le dernier pointers.
            int last = pointers.getLast() + 1;
            pointers.removeLast();
            pointers.add(last);

            // 5. Fill la liste de pointers.
            while(pointers.size() < k){
                pointers.add(pointers.getLast() + 1);
            }
        }
    }
    public boolean canIncrementLastPointers(List<Integer> pointers, List<Integer> values, int k){
        int valueSize =  values.size();
        int lastPlusOne = pointers.getLast() + 1;
        int kTwo = k;
        int pointersSize = pointers.size();




        boolean rs =  values.size() > (pointers.getLast() + 1 + (k - pointers.size()));
        return rs;
    }

    // Recursive Tree
    public List<List<Integer>> tryRecursive(int n, int k){
        List<Integer> values = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            values.add(i);
        }

        // [1, 2, 3]
        List<List<Integer>> output = new ArrayList<>();

        int idx = 0;
        for(int val : values){
         helper_recursive_v3(output, values, new ArrayList<>(), idx, k);
         idx++;
        }
        return output;
    }

    public void helper_recursive(List<List<Integer>> out, List<Integer> vals, List<Integer> tmp, int idx, int k){
        if(tmp.size() == k){
            out.add(tmp);
            return;
        }

        if(!(idx >= vals.size())){
            List<Integer> newLst = new ArrayList<>(tmp);
            newLst.add(vals.get(idx));
            helper_recursive(out, vals, newLst, idx + 1, k);
        }

        if(!(idx + 1 >= vals.size())){
            List<Integer> newLst = new ArrayList<>(tmp);
            newLst.add(vals.get(idx + 1));
            helper_recursive(out, vals, newLst, idx + 2, k);
        }
    }
    public void helper_recursive_v2(List<List<Integer>> out, List<Integer> vals, List<Integer> tmp, int idx, int k){
        List<Integer> current = new ArrayList<>(tmp);
        current.add(vals.get(idx));

        // Base case.
        if(current.size() == k){
            out.add(new ArrayList<>(current));
            current.removeFirst();
        }


        // Find the number of recursive call.
        List<Integer> idxRecursiveCall = new ArrayList<>();
        for(int i = idx + 1; i < vals.size(); i++){
            idxRecursiveCall.add(i);
        }

        // Base case.
        if(idxRecursiveCall.isEmpty()) return;

        // Recursive call.
        for(int index : idxRecursiveCall){
            helper_recursive_v2(out, vals, current, index, k);
        }
    }
    public void helper_recursive_v3(List<List<Integer>> out, List<Integer> vals, List<Integer> tmp, int idx, int k){
        List<Integer> current = new ArrayList<>(tmp);
        current.add(vals.get(idx));

        if(current.size() == k){
            out.add(new ArrayList<>(current));
            return;
        }

        List<Integer> nextIdx = new ArrayList<>();
        for(int i = idx + 1; i < vals.size(); i++){
            nextIdx.add(i);
        }

        if(nextIdx.isEmpty()) return;

        for(int next : nextIdx){
            helper_recursive_v3(out, vals, current, next, k);
        }
    }


    public List<List<Integer>> correction(int n, int k){
        List<List<Integer>> out = new ArrayList<>();
        backTracking(1, n, k, new ArrayList<>(), out);
        return out;
    }

    public void backTracking(int start, int n, int k, List<Integer> current, List<List<Integer>> out){
        if(current.size() == k){
            out.add(new ArrayList<>(current));
            return;
        }

        for(int v = start; v <= n; v++){
            // Choix possible 1, 2, 3. // 2, 3 // 3.
            current.add(v);
            backTracking(v + 1, n, k, current, out);
            current.removeLast();
        }
    }

    // ______________ Helper Display _______________
    public void displayList(List<Integer> lst){
        System.out.print(" List content => [");
        for(int el : lst){
            System.out.print(el + ", ");
        }
        System.out.print(']');
        System.out.println();
    }
}
