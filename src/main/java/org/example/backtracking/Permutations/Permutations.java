package org.example.backtracking.Permutations;

import java.util.*;

public class Permutations {
    // ==================== FIRST ITERATION ====================
    public List<List<Integer>> firstIteration(List<Integer> input){
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < input.size(); i++){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(input.get(i));

            backTracking(input, input.size(), tmp, output);
        }
        return output;
    }
    public void backTracking(List<Integer> input, int length, List<Integer> curr, List<List<Integer>> out){
        if(curr.size() == length){
            out.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < input.size(); i++){
            if(curr.contains(input.get(i)))continue;
            curr.add(input.get(i));

            backTracking(input, length, curr, out);

            curr.removeLast();
        }
    }

    // ==================== SECOND ITERATION ====================
    public List<List<Integer>> secondIteration(List<Integer> input){
        // Idée principal gérer un set inputIndex ainsi que, usedIndex afin de supprimer le cout de .contains.
        List<List<Integer>> output = new ArrayList<>();

        Set<Integer> inputIdx = new HashSet<>();
        for(int i = 0; i < input.size(); i++){
            inputIdx.add(i);
        }

        //Set<Integer> inputSet = new HashSet<>(input);
        //System.out.println(inputSet);

        for(int i = 0; i < input.size(); i++){
            backTracking2(input.size(), input, inputIdx, new ArrayList<>(List.of(i)), output);
        }
        return output;
    }
    public void backTracking2(int len, List<Integer> input, Set<Integer> inputIndex, List<Integer> curr, List<List<Integer>> out){
            // Base case :
            if(curr.size() == len){
                List<Integer> tmp = new ArrayList<>();
                for(int idx : curr){
                    tmp.add(input.get(idx));
                }

                out.add(tmp);
                return;
            }

            // On ne garde que les indices non utilisés
            Set<Integer> availableIndex = new HashSet<>(inputIndex);
            availableIndex.removeAll(curr);

            for(int idx: availableIndex){
                curr.add(idx);
                backTracking2(len, input, inputIndex, curr, out);
                curr.removeLast();
            }
    }

    // ==================== THIRD ITERATION =====================
    public List<List<Integer>> thirdIteration(List<Integer> input){
        List<List<Integer>> output = new ArrayList<>();
        List<Boolean> used = new ArrayList<>();

        for(int i = 0; i < input.size(); i++){
            used.add(false);
        }
        // [False, False, False]

        for(int i = 0; i < input.size(); i++){
            used.set(i, true);
            backTracking3(input.size(), input, used, new ArrayList<>(List.of(input.get(i))), output);
            used.set(i, false);
        }
        return output;
    }
    public void backTracking3(int size, List<Integer> input, List<Boolean> used, List<Integer> current, List<List<Integer>> out){
        if(current.size() == size){
            out.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < used.size(); i++){
            if(used.get(i)) continue;

            used.set(i, true);
            current.add(input.get(i));

            backTracking3(size, input, used, current, out);

            used.set(i, false);
            current.removeLast();
        }
    }


    // ===================== NeetCode Solution =====================
    // 1, 2, 3 => 2, 3 => 3 => Base case return [3].


    public List<List<Integer>> neetCode(List<Integer> input){
        List<List<Integer>> out = new ArrayList<>();
        recursiveCall(input, out);
        return out;
    }

    public void recursiveCall(List<Integer> input, List<List<Integer>> output){
        if(input.size() == 1){
            output.add(List.of(input.getFirst()));
            return;
        }

        int current = input.getFirst();
        input.removeFirst();
        recursiveCall(input, output);

        System.out.println("Retour de l'appel récursif");
        List<List<Integer>> sub = new ArrayList<>();
        for(List<Integer> el : output){ // [3]

            int size = el.size(); // 1, 2, 3.
            for(int i = 0; i <= size; i++){ // 0 -> 1.
                List<Integer> tmp = new ArrayList<>(el);
                tmp.add(i, current);
                sub.add(tmp);
            }
        }

        output.clear();
        output.addAll(sub);
    }

    public List<List<Integer>> permutate(int[] nums){
        if(nums.length == 0){
            List<Integer> innner = new ArrayList<>();
            List<List<Integer>> outer = new ArrayList<>();
            outer.add(innner);
            return outer;
            // Ici mon objectif est de retourner une list de tableau vide.
        }

        List<List<Integer>> result = permutate(Arrays.copyOfRange(nums, 1, nums.length)); // [ [3] ]
        List<List<Integer>> tmp = new ArrayList<>();

        for(List<Integer> el : result){
            for(int i = 0; i <= el.size(); i++){
                List<Integer> inner = new ArrayList<>(el); // []
                inner.add(i, nums[0]); // [2, 3], [3]
                tmp.add(inner);
            }
        }
        return tmp;
    }

    public List<List<Integer>> permutateIterative(List<Integer> nums){
        List<List<Integer>> out = new ArrayList<>();
        out.add(nums);

        List<Integer> clone = new ArrayList<>(nums);
        while(true){
            for(int i = 0; i < nums.size() - 1; i++){
                int j = i+1;

                int tmp = clone.get(i);
                clone.set(i, clone.get(j));
                clone.set(j, tmp);

                if(Objects.equals(clone, nums))return out;
                out.add(new ArrayList<>(clone));
            }
        }
    }

    // Iterative Correction.
    public List<List<Integer>> iterative(List<Integer> nums){
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());

        for(int i = 0; i < nums.size(); i++){
            // 1, 2, 3. // 1.
            List<List<Integer>> outer = new ArrayList<>(); // []

            for(List<Integer> el : out){ // []
                for(int j = 0; j <= el.size(); j++){
                    List<Integer> inner = new ArrayList<>(el); // [], [3]
                    inner.add(j, nums.get(i)); // [2, 3], [3, 2]...
                    outer.add(inner);
                }
            }
            out.clear(); // []
            out.addAll(outer); // [3]
        }
        return out;
    }

    // Recursive
    public void recursiveReDo(List<List<Integer>> out, List<Integer> input){
        if(input.size() == 1){
            out.add(input);
            return;
        }

        List<Integer> clone = new ArrayList<>(input);
        int current = clone.getLast();
        clone.removeLast();

        recursiveReDo(out, clone);

        //________________ Recursive Call ______________
        List<List<Integer>> outer = new ArrayList<>();
        for(List<Integer> el : out){
            for(int i = 0; i <= el.size(); i++){
                List<Integer> inner = new ArrayList<>(el);
                inner.add(i, current);
                outer.add(inner);
            }
        }
        out.clear();
        out.addAll(outer);
    }

    // BackTracking
    public void backTrack(List<List<Integer>> out, List<Integer> input, List<Integer> tmp){
        // Base case
        if(tmp.size() == 3){
            out.add(new ArrayList<>(tmp));
            return;
        }

        // update input with only not used value.
        List<Integer> inner = new ArrayList<>(input);
        if(!tmp.isEmpty()){
            for(int el : tmp){
                removed(inner, el);
            }
        }

        for(int i = 0; i < inner.size(); i++){
            tmp.add(inner.get(i));
            backTrack(out, inner, tmp);
            tmp.removeLast();
        }
    }
    public void removed(List<Integer> inner, int el){
        for(int i = 0; i < inner.size(); i++){
            if(inner.get(i) == el){
                inner.remove(i);
                break;
            }
        }
    }


    public void betterBackTrack(List<List<Integer>> out, List<Integer> input, List<Integer> tmp){
        if(tmp.size() == input.size()){
            out.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0; i < input.size(); i++){
            if(!tmp.isEmpty() && tmp.contains(input.get(i)))continue;

            tmp.add(input.get(i));
            betterBackTrack(out, input, tmp);
            tmp.removeLast();
        }
    }
}
