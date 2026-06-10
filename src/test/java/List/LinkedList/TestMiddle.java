package List.LinkedList;

import org.example.linkedList.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMiddle {
    LinkedList<Integer> ll;
    int[] input = new int[]{1, 2, 3, 4, 5};
    int output = 3;

    @BeforeEach
    public void setUp(){
        ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
    }

    @Test
    public void testMiddle(){
        Assertions.assertEquals(output, ll.middle());
    }
}
