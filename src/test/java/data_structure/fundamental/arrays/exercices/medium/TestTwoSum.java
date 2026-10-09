package data_structure.fundamental.arrays.exercices.medium;
import org.example.data_structure.fundamental.arrays.exercices.medium.TwoSum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestTwoSum {
    int target = 40;
    int[] arr = new int[]{2, 22, 6, 5, 8, 11};


    int[] arr2 = new int[]{5, 1, 1, 1, 8, 11};
    int targetThreeSumTwo = 21;

    TwoSum twoSum;

    @BeforeEach
    public void setUp(){
        this.twoSum = new TwoSum();
    }

    @Test
    public void testFirstVariantBrutForce(){
        var result = twoSum.firstVariantBrutForce(arr, target);
        // System.out.println(result);
    }

    @Test
    public void testSecondVariantBetter(){
        var result = twoSum.optimal(arr, target);
        //System.out.println(result);
    }

}
