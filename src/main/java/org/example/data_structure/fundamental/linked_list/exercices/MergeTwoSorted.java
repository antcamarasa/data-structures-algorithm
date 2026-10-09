package org.example.data_structure.fundamental.linked_list.exercices;

import org.example.data_structure.list.List;

import java.util.ArrayList;
import java.util.LinkedList;

public class MergeTwoSorted {
    public Integer brutForce(ArrayList<Integer> lst1, ArrayList<Integer> lst2){
        LinkedList<Integer> ll = new LinkedList<>();

        while (!lst1.isEmpty() && !lst2.isEmpty()){
            if(lst1.getFirst() <= lst2.getFirst())
                ll.add(lst1.removeFirst());
            ll.add(lst2.removeFirst());
        }

        if(!lst1.isEmpty()){
            ll.addAll(lst1);
        }
        else{
            ll.addAll(lst2);
        }

        for(Integer el : ll){
            System.out.println(el);
        }
        return ll.getFirst();
    }
}
