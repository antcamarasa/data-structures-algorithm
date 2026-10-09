package data_structure.fundamental.circularly_linked_list;
import org.example.data_structure.fundamental.circularly_linked_list.CircularLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCircularLinkedList<E> {
    CircularLinkedList<Integer> circular;

    @BeforeEach
    public void setUp(){

        this.circular = new CircularLinkedList<>();
    }

    @Test
    public void circularLinkedListTest(){
        circular.addFirst(1);
        circular.addFirst(2);
        circular.addFirst(3);
        circular.display();
    }
}
