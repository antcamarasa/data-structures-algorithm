package data_structure.fundamental.arrays.exercices.easy;

import org.example.data_structure.fundamental.arrays.exercices.easy.CheckIfArrayIsSorted;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestCheckIfArraysIsSorted {
    CheckIfArrayIsSorted arrayIsSorted;

    @BeforeEach
    public void setUp(){
            this.arrayIsSorted = new CheckIfArrayIsSorted();
    }

    @Test
    public void testBrutForce(){
        int[] array = {1,2,3,4,5};
        Assertions.assertTrue(arrayIsSorted.bruteForce(array));
        Assertions.assertTrue(arrayIsSorted.optimalApproach(array, array.length));
    }

}
