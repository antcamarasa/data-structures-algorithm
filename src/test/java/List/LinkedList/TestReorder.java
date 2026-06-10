package List.LinkedList;

import org.example.linkedList.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReorder {
    LinkedList<Integer> ll;

    @BeforeEach
    public void setUp(){
        ll = new LinkedList<>();
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
    }

    @Test
    public void testReorder(){
        ll.reorderReverseAndMerge();
        ll.displayLinkedList();
    }
}
