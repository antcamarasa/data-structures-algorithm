package data_structure.fundamental.arrays.exercices.easy;
import org.example.data_structure.fundamental.arrays.exercices.easy.LargestElement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestLargestElement {

    @Test
    public void testLargestElement(){
        int[] data = {2, 5, 1, 3, 0};
        int output = 5;


        int[] data_2 = {8, 10, 5, 7, 9};
        int output_2 = 10;

        LargestElement largestElement = new LargestElement();
        Assertions.assertEquals(output, largestElement.bruteForce(data));
        Assertions.assertEquals(output_2, largestElement.bruteForce(data_2));
    }


}
