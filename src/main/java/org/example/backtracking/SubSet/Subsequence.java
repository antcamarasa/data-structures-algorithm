package org.example.backtracking.SubSet;
import java.util.*;

public class Subsequence {
    Set<String> destination;

    public Set<String> brutForce(String s){
        int counter = 1;
        destination = new LinkedHashSet<>();

        while(counter <= s.length()) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                int start = 0;
                for (int j = start; j < s.length(); j++) {
                    for (int inner = j; inner < s.length(); inner++) {
                        tmp.add(String.valueOf(s.charAt(inner)));
                        if (tmp.size() == counter) {
                            destination.add(String.join("", tmp));
                            // remove
                            if (counter == 1) tmp.clear();
                            else if (counter == 2) tmp.removeLast();
                            else{
                                String curr = tmp.removeLast();

                                // A, B, C // Inner va valoir D
                                      // 1. remove B
                                      // 2. remove C

                                // tmp1 (A, B)
                                // tmp2 (A, C)
                            }
                        }
                    }
                    tmp.clear();
                }
                counter++;
            }
        }
        return destination;
    }

    public Set<String> getAllSubSequence(String str){
        Set<String> subs = new HashSet<>();

        int count = 0;
        while (count <= str.length()){
            subs.addAll(isolateComplexSubset(str, count));
            count++;
        }
        return subs;
    }

    public Set<String> isolateComplexSubset(String s, int counter){
        // L'idée est la suivante :
        // 1. On crée un liste de pointeur correspondant a counter. Si counter = 2, deux pointers.
        //                                                          Si counter = 3, trois pointers.
        // 2. On construit nos sous séquence en fonctionnant comme cela :
        //    1. On remplit avec tous les pointeurs (0, 1) lst "abc" counter = 2 => "ab" // (0, 2) => "ac".
        //    2. On incrémente, le dernier pointeur de 1 (0, 2) 2 > len(s) non donc ok  et on remplis ^

        //    3. Maintenant le dernier pointer > 3 == s.size() donc on ne peut plus continuer.
        //       On supprime ce dernier pointer. pointers.removeLast()
        //       On récupérer le nouveau dernier pointer 0 => On l'increment de 1 => pointer(1);
        //       On rempli la liste pointer pour qu'elle ai le nbr de pointeur nécessaire : pointer(1, 1+1, ..)
        //       Chaque pointer doit être + 1 => Si le nouveau dernier pointer supérieur à s.size() on s'arrete.

        //       (1, 2) => bc. On repasse a l'étape 2, on incrémente 2 + 1 3 au dessus. on retire.
        //       On repasse a l'étape 2 => 2, 3 => 3 au dessus donc on s'arrête fin.
        Set<String> subSet = new HashSet<>();
        List<Integer> pointers = new ArrayList<>();
        for(int i = 0; i < counter; i++){
            pointers.add(i);
        }


        while(true){
            StringBuilder sb = new StringBuilder();
            if(pointers.size() == counter){
                for(int ptr : pointers){
                    sb.append(String.valueOf(s.charAt(ptr)));
                }
                subSet.add(sb.toString());
            }


            // Increment lastPointer.
            int last = pointers.removeLast();
            last = last +1; // 2
            while(last >= s.length()){
                  if(!pointers.isEmpty()){
                      last = pointers.removeLast();
                      last = last + 1;
                  }
                  else{
                      return subSet;
                  }
            }

            // Fill with new Pointers //
            while(pointers.size() < counter){ // 1 => 2
                if(last < s.length()){
                    pointers.add(last);
                    last = last + 1;
                    continue;
                }
                break;
            }
        }
    }
    public Set<String> recursiveSubset(String str){
        Set<String> result = new HashSet<>();
        List<Integer> ptrs = new ArrayList<>();

        for (int i = 0; i < str.length() + 1; i++){
            for(int j = 0; j < i; j++){
                ptrs.add(j);
            }

            var rs = helperSubset(str, i, ptrs);
            if(!rs.isEmpty()){
                result.addAll(rs);
            }
            ptrs.clear();
        }
        return result;
    }
    public Set<String> helperSubset(String s, int len, List<Integer> pointers){
        Set<String> rs = new HashSet<>();
        if(pointers.isEmpty()){
            return rs;
        }

        // 1.
        if(pointers.size() == len){
            StringBuilder sb = new StringBuilder();
            for(int ptr : pointers)sb.append(String.valueOf(s.charAt(ptr)));
            rs.add(sb.toString());
        }

        int last = pointers.removeLast();
        last = last + 1;

        while(pointers.size() != len){
            if(last < s.length()){
                pointers.add(last);
                last = last + 1;
                continue;
            }
            break;
        }

        var result = helperSubset(s, len, pointers);
        rs.addAll(result);
        return rs;
    }


    // TODO : Rien car fini !
    public List<String> dfs2(String str, int index, List<String> tmp){
        List<String> result = new ArrayList<>();
        if(index == str.length()){
            String rs = String.join("", tmp);
            List<String> rsLst = new ArrayList<>();
            rsLst.add(rs);
            return rsLst;
        }

        var returnLst = dfs2(str, index + 1, tmp);
        for(String rs : returnLst){
            result.add(rs);
        }

        List<String> tmp2 = new ArrayList<>(tmp);
        tmp2.add(String.valueOf(str.charAt(index)));

        var returnLst2 = dfs2(str, index + 1, tmp2);
        for(String rs : returnLst2){
            result.add(rs);
        }

        return result;
    }

    public void dfs(String str, int index, List<String> tmp, Set<String> result){
        if(index >= str.length()){
            result.add(String.join("", tmp));
            return;
        }

        dfs(str, index + 1, tmp, result);
        List<String> inner = new ArrayList<>();
        for(String el : tmp){
            inner.add(el);
        }

        inner.add(String.valueOf(str.charAt(index)));

        dfs(str, index + 1, inner, result);
    }

    public void display(){
        if(!destination.isEmpty()){
            System.out.print("[ ");
            for(String el : destination){
                System.out.print(el + ", ");
            }
            System.out.println("]");
        }
    }
}
