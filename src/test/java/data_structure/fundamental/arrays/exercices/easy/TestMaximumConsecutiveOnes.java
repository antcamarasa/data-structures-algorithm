package data_structure.fundamental.arrays.exercices.easy;

import org.example.data_structure.fundamental.arrays.exercices.easy.MaximumConsecutiveOnes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMaximumConsecutiveOnes {
    MaximumConsecutiveOnes max;
    int[] input = {1, 1, 0, 1, 1, 1};
    int output = 3;

    int[] input2 = {1, 0, 1, 1, 0, 1};
    int output2 = 2;

    @BeforeEach
    public void setUp(){
        this.max = new MaximumConsecutiveOnes();
    }

    @Test
    public void testBrutForce(){
        var result = max.betterApproach(input);
        System.out.println("result : " + result);
    }

}
