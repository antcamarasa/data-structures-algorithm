package data_structure.arrays.exercices.easy;

import org.example.data_structure.arrays.exercices.easy.LeftRotateByOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLeftRotateByOne {
    // DATA Pour les test
    int[] input = {1, 2, 3, 4, 5};
    int[] output = {2, 3, 4, 5, 1};

    LeftRotateByOne leftRotateByOne;

    @BeforeEach
    public void setUp(){
        this.leftRotateByOne = new LeftRotateByOne();
    }

    @Test
    public void testBrutForce(){
        Assertions.assertArrayEquals(output, leftRotateByOne.optimalVersion(input));
    }
}
