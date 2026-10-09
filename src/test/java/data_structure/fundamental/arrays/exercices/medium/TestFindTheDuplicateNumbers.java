package data_structure.fundamental.arrays.exercices.medium;
import org.example.data_structure.fundamental.arrays.exercices.medium.FindTheDuplicateNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFindTheDuplicateNumbers {
    FindTheDuplicateNumber find;

    int[] nums = new int[]{1, 2, 3, 2, 2};
    int output = 2;

    int[] nums2 = new int[]{1, 3, 4, 2, 2};
    int output2 = 2;

    int[] nums3 = new int[]{1, 2, 3, 4, 5};
    int middle = 3;

    @BeforeEach
    public void setUp(){
        this.find = new FindTheDuplicateNumber();
    }

    @Test
    public void testSolveUsingSet(){
        Assertions.assertEquals(output, find.solvedUsingSet(nums));
        Assertions.assertEquals(output2, find.solvedUsingSet(nums2));
    }

    @Test
    public void testSolveWithoutAllocate(){
        Assertions.assertEquals(output, find.solveWithoutAllocation(nums));
        Assertions.assertEquals(output2, find.solveWithoutAllocation(nums2));
    }

    @Test
    public void testHasCycle(){
        boolean result = find.hasCycle(nums3);
        System.out.println(result);
    }
}
