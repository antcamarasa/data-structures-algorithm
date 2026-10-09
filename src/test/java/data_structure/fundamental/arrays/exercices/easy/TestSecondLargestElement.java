package data_structure.fundamental.arrays.exercices.easy;

import org.example.data_structure.fundamental.arrays.exercices.easy.SecondLargestAndSmallest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSecondLargestElement {
        SecondLargestAndSmallest second;

        @BeforeEach
        public void setUp(){
            this.second = new SecondLargestAndSmallest();
        }


        @Test
        public void testLargestElement(){
            int[] data = {1, 2, 4, 7, 7, 5};
            int secondMinimum = 2;
            int secondMaximum = 5;

            int[] data_2 = {1};
            int output_2 = -1;

            Assertions.assertEquals(secondMinimum, second.brutForceSecondMinium(data));
            Assertions.assertEquals(secondMaximum, second.brutForceSecondMaximum(data));
        }


        @Test
        public void testSecondLargestBetterSolution(){
            int[] data = {1, 2, 4, 6, 7, 5};
            int[] seconds = {2, 6};

            Assertions.assertArrayEquals(seconds, second.betterSolution(data));
        }
}

