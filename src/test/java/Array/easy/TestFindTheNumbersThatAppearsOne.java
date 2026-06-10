package Array.easy;

import org.example.array.exercice.easy.FindTheNumbersThatAppearsOne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFindTheNumbersThatAppearsOne {
    FindTheNumbersThatAppearsOne findNums;
    int[] arr = {2, 2, 1};
    int output = 1;

    int[] arr2 = {4, 1, 2, 1, 2};
    int output2 = 4;

    @BeforeEach
    public void setUp(){
        this.findNums = new FindTheNumbersThatAppearsOne();
    }

    @Test
    public void testSolveUsingHashWithArray(){
        int result = findNums.solveUsingHashWithArray(arr2);
        System.out.println(result);
    }

    @Test
    public void testSolveUsingHashing(){
        var rs = findNums.solveUsingHashingFirst(arr);
        System.out.println("result : " + rs);
    }
}
