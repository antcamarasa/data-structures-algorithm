package org.example.algorithms.backtracking.exercices.permutations;
import java.util.*;

public class NextPermutation {
    // ___________________ First Iteration ___________________
    // Etape 1.
    public List<List<Integer>> getAllPermutation(List<Integer> input){
        List<List<Integer>> all = new ArrayList<>();

        List<Integer> current = new ArrayList<>(input);

        while(true){
            if(all.isEmpty()) all.add(new ArrayList<>(current));
            for(int i = 0; i < input.size() - 1; i++){
                int j = i+1;

                int tmp = current.get(i);
                current.set(i, current.get(j));
                current.set(j, tmp);

                if(Objects.equals(input, current)) return all;
                all.add(new ArrayList<>(current));
            }
        }
    }

    // Etape 2.
    public List<List<Integer>> sortedAllPermutation(List<List<Integer>> all){
        // 1. Créer un tableau de valeur plus petite à plus grande. [1, 2, 3] correspond à index 0.
        // 2. Utilise la stratégie two pointers pour trier cette sous partie.
        // 3. On continue jusqu'à tout avoir trier.
        int idx = 0;
        int beginIndex = 0;
        Integer currentMin = null;

        // 0, 1, 2. =x  Loop over idx
            for(int start = 0; start < all.size(); start++){
                // idx = 3 | 2 | 1.
                currentMin = getMinValue(all, idx, currentMin); // 3. // 2. // 1.


                    for(int curr = start; curr < all.size(); curr++){
                        if(all.get(curr).get(idx) == currentMin){
                            var tmp = all.get(beginIndex);
                            all.set(beginIndex, all.get(curr));
                            all.set(curr, tmp);
                            beginIndex++;
                        }
                    }
                    sortedSubList(all, start, beginIndex, idx);
                    start = beginIndex - 1;
            }
            return all;
    }
    public int getMinValue(List<List<Integer>> all, int idx, Integer exclusive){

        // exclusive = 3 toutes valeurs > exclusive.
        // SI exclusive est null alors rien

        int min = Integer.MAX_VALUE;

        for(List<Integer> lst : all){
            if(exclusive == null){
                if(lst.get(idx) < min) min = lst.get(idx);
            }
            if(exclusive != null){
                if(lst.get(idx) > exclusive && lst.get(idx) < min) min = lst.get(idx);
            }
        }
        return min;
    }
    public void sortedSubList(List<List<Integer>> all, int start, int end, int from){
        for(int i = start; i < end; i++){ // i => 0 et 1.
            for(int j = i + 1; j < end; j++){ // j => 1 et 2 stop.
                for(int x = from + 1; x < all.get(i).size(); x++){
                    if(all.get(i).get(x) < all.get(j).get(x)) break;
                    if(all.get(i).get(x) > all.get(j).get(x)){
                        // Swap
                        var tmp = all.get(i);
                        all.set(i, all.get(j));
                        all.set(j, tmp);
                        break;
                    }
                }
            }

        }
    }

    // Etape 3.
    public List<Integer> nextPermutation(List<Integer> input){
        System.out.println("Input : " + input);



        List<List<Integer>> allSortedPermutation = sortedAllPermutation(getAllPermutation(input));


        for(int i = 0; i < allSortedPermutation.size(); i++){
            if(Objects.equals(input, allSortedPermutation.get(i)) && i + 1 < allSortedPermutation.size()){
                return allSortedPermutation.get(i + 1);
            }
        }
        return allSortedPermutation.getFirst();
    }


    // ___________________ First Iteration ___________________
    // TODO => V3 corrction a faire :
    //  1. au lieu de getAllNextValue, iterer sur une liste de candidats non utilisé. maintenir une liste used afin de séparer construction et tracking des choix déja pris
    //  2. Attention au doublons.
    public List<List<Integer>> nextPermutation2(List<Integer> input){
        List<List<Integer>> out = new ArrayList<>();

        for(int i = 0; i < input.size(); i++){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(input.get(i));
            backTracking(input.size(), input, tmp, out);
        }
        return out;
    }
    public void backTracking(int size, List<Integer> input, List<Integer> tmp, List<List<Integer>> out){
        if(tmp.size() == size){
            out.add(new ArrayList<>(tmp));
            return;
        }

        List<Integer> allNextValue = getAllNextValue(tmp, input);
        for(int el : allNextValue){
            tmp.add(el);
            backTracking(size, input, tmp, out);
            tmp.removeLast();
        }
    }
    public List<Integer> getAllNextValue(List<Integer>curr, List<Integer> source){
        List<Integer> allNextValue = new ArrayList<>();
        for(int el : source){
            if(curr.contains(el))continue;
            allNextValue.add(el);
        }
        return allNextValue;
    }

    // output [], input [1, 2, 3]
    public void getAllPermutation(List<List<Integer>> out, List<Integer> input, List<Integer> tmp){
        if(tmp.size() == input.size()){
            out.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = input.size() - 1; i >= 0; i--){
            if(!tmp.isEmpty() && tmp.contains(input.get(i))){continue;}

            tmp.add(input.get(i));
            getAllPermutation(out, input, tmp);
            tmp.removeLast();
        }
    }

    // TODO => Trié par un moyen fonctionnel regarder les logs/
    public void sortedNextPermutations(List<List<Integer>> allPermutation, List<Integer> input){
        for(int current = 0; current < allPermutation.size() - 1; current++){
            int next = current + 1;

            while(next < allPermutation.size()){
                for(int i = 0; i < allPermutation.get(i).size(); i++){
                    System.out.println("current : " + allPermutation.get(current).get(i));
                    System.out.println("Next : " +  allPermutation.get(next).get(i));

                    if(allPermutation.get(current).get(i) < allPermutation.get(next).get(i))break;

                    if(allPermutation.get(current).get(i) > allPermutation.get(next).get(i)){
                        var tmp = allPermutation.get(current);
                        allPermutation.set(current, allPermutation.get(next));
                        allPermutation.set(next, tmp);
                        break;
                    }
                }
                next++;
            }
        }

        System.out.println("All permutation sorted : " + allPermutation);
    };

    public List<Integer> nextPermutation(List<List<Integer>> out, List<Integer> input){
        for(int i = 0; i < out.size(); i++){
               if(Objects.equals(input, out.get(i))){
                    return i + 1 < out.size() ? out.get( i + 1) : out.getFirst();
               }
        }
        return null;
    }
}
