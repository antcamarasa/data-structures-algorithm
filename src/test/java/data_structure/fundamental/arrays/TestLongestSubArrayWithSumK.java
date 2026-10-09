package data_structure.fundamental.arrays;

import org.example.data_structure.fundamental.arrays.exercices.easy.LongestSubarrayWithGivenSum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLongestSubArrayWithSumK {
    LongestSubarrayWithGivenSum longest;
    int[] arr = new int[]{10, 5, 2, 7, 1, 9};
    int k = 15;

    int[] arr2 = new int[]{-3, 2, 1};
    int k2 = 6;

    @BeforeEach
    public void setUp(){
        this.longest = new LongestSubarrayWithGivenSum();
    }

    @Test
    public void testLongestSubArrayWithGivenSum(){
        int result = longest.correctionSlidingWindowAndTwoPointers(arr, k);
        System.out.println(result);
    }


}
