package algorithms.backtracking.exercices.combinations;
import org.example.algorithms.backtracking.exercices.combinations.Combinations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestCombinations {
    Combinations combinations;

    @BeforeEach
    public void setUp(){
        this.combinations = new Combinations();
    }

    @Test
    public void testBrutForce(){
        int n = 3;
        int k = 2;

        Set<List<Integer>> output = new HashSet<>();
        output.add(new ArrayList<>(List.of(1, 2)));
        output.add(new ArrayList<>(List.of(1, 3)));
        output.add(new ArrayList<>(List.of(2, 3)));

        Assertions.assertEquals(output, combinations.brutForce(n, k));
    }

    @Test
    public void testTryRecursive(){
        int n = 3;
        int k = 2;

         var rs = combinations.correction(n, k);
        System.out.println("Rsultat : " + rs);
    }


}
