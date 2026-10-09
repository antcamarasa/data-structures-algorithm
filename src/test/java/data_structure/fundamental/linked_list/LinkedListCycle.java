package data_structure.fundamental.linked_list;

import org.example.data_structure.fundamental.linked_list.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListCycle {
    LinkedList<Integer> ll;

    @BeforeEach
    public void setup(){
        this.ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
    }

    @Test
    public void testHasCycleFAstAndSlow(){
        var result = ll.hasCycleFastAndSlow();
        System.out.println(result);
        //ll.displayNode(result);
    }

}
