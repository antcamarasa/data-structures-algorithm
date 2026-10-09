package data_structure.map.implementation.separate_chaining;

import org.example.data_structure.map.implementation.my_implementation.separate_chaining.MyMapSeparateChaining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestMyMapSeparateChaining {
    // Ici, je suis obligé d'utiliser des types réél et non génériques.
    private MyMapSeparateChaining<Integer, String> student;


    @BeforeEach
    public void setUp(){
        student = new MyMapSeparateChaining<>();
    }

    @Test
    public void testReHash(){
        student.put(1, "A");
        student.put(11, "B");
        student.put(2, "C");
        student.put(22, "D");
        student.put(3, "E");
        student.put(5, "F");
    }
}
