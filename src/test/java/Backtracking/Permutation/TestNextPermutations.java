package Backtracking.Permutation;
import org.example.backtracking.Permutations.NextPermutation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestNextPermutations {
    NextPermutation next;
    record TestCase(List<Integer> input, List<List<Integer>> output){};


    @BeforeEach
    public void setUp(){
        this.next = new NextPermutation();
    }

    @Test
    public void testGetAllPermutations(){
        List<List<Integer>> expectedOutput = new ArrayList<>(new ArrayList<>());
        expectedOutput.add(new ArrayList<>(List.of(1, 2, 3)));
        expectedOutput.add(new ArrayList<>(List.of(1, 3, 2)));
        expectedOutput.add(new ArrayList<>(List.of(2, 1, 3)));
        expectedOutput.add(new ArrayList<>(List.of(2, 3, 1)));
        expectedOutput.add(new ArrayList<>(List.of(3, 1, 2)));
        expectedOutput.add(new ArrayList<>(List.of(3, 2, 1)));

        TestCase case1 = new TestCase(new ArrayList<>(List.of(1,2,3)), expectedOutput);

        // TODO
        //var allPermutations = next.getAllPermutation(case1.input);
        //next.sortedAllPermutation(allPermutations);

        //var rs = next.getAllPermutation(case1.input);
        //next.sortedAllPermutation(rs);
        //System.out.println("Result : " + rs);
        var nextPermutation = next.nextPermutation(case1.input);
        System.out.println(nextPermutation);
    }

    @Test
    public void testBackTracking(){
        List<Integer> input = new ArrayList<>(List.of(1,2,3));
        next.nextPermutation2(input);
    }

    @Test
    public void testGetAllPermutation(){
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> input = new ArrayList<>(List.of(3, 2, 1));

        next.getAllPermutation(out, input, new ArrayList<>());


        next.sortedNextPermutations(out, input);
        System.out.println("Out > " + out);

        var result =  next.nextPermutation(out, input);
        System.out.println("Result > " + result);
    }
}
