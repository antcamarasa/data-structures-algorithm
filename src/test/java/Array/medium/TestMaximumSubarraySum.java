package Array.medium;

import org.example.array.exercice.medium.maximumSubarraySum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMaximumSubarraySum {
    int[] numsEasier = new int[]{2, 3, 5};
    int[] nums = new int[]{2, 3, 5, -2, 7, -4};
    int output = 15;

    int[]nums2 = new int[]{-2, -3, -7, -2, -10, -4};
    int output2 = -2;

    maximumSubarraySum maxSubArray;

    @BeforeEach
    public void setUp(){
        this.maxSubArray = new maximumSubarraySum();
    }

    @Test
    public void testBrutForce(){
        Assertions.assertEquals(output, maxSubArray.brutForceFirstIteration(nums));
        Assertions.assertEquals(output2, maxSubArray.brutForceFirstIteration(nums2));
    }

    @Test
    public void testRecursive(){
        maxSubArray.recursive(nums);
    }
}
