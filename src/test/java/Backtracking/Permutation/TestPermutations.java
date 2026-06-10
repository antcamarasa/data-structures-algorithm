package Backtracking.Permutation;
import org.example.backtracking.Permutations.Permutations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class TestPermutations {
    Permutations permutation;

    @BeforeEach
    public void setUp(){
        this.permutation = new Permutations();
    }

    @Test
    public void testFirstIteration(){
        List<Integer> input = new ArrayList<>(List.of(1, 2, 3));
        List<List<Integer>> output = new ArrayList<>(
                List.of(
                        List.of(1, 2, 3),
                        List.of(1, 3, 2),
                        List.of(2, 1, 3),
                        List.of(2, 3, 1),
                        List.of(3, 1, 2),
                        List.of(3, 2, 1)
                )
        );

        var rs = permutation.thirdIteration(input);
        System.out.println("Result => " + rs);
    }

    @Test
    public void testNeetCode(){
        List<Integer> input = new ArrayList<>(List.of(1, 2, 3));
        var rs = permutation.neetCode(input);
        System.out.println("Resultat : " + rs);
    }

    @Test
    public void testPermutate(){
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;

        var rs = permutation.permutate(nums);
        System.out.println("Result : " + rs);
    }

    @Test
    public void testPermutateIterative(){
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3));

        var result = permutation.permutateIterative(nums);
        System.out.println("Result : " + result);
    }

    @Test
    public void testIterative(){
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3));
        var result = permutation.iterative(nums);
        System.out.println("Result : " + result);
    }


    @Test
    public void testBackTrack(){
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> input = new ArrayList<>(List.of(1, 2, 3));
        permutation.betterBackTrack(out, input, new ArrayList<>());

        System.out.println("Output result => " + out);
    }
}
