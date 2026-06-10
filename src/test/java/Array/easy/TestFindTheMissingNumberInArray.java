package Array.easy;
import org.example.array.exercice.easy.FindTheMissingNumberInArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFindTheMissingNumberInArray {
    FindTheMissingNumberInArray missing;

    // ________________ DATA ______________
    int n = 5;
    int m = 3;
    int[] arr = {1, 2, 4, 5};
    int[] arr2 = {1, 3};

    @BeforeEach
    public void setUp(){
        this.missing = new FindTheMissingNumberInArray();
    }

    @Test
    public void testBrutForce(){
        var element = missing.bruteForce(n, arr);
        System.out.println(element);

        var element2 = missing.bruteForce(m, arr2);
        System.out.println(element2);
    }

    @Test
    public void testBetterApproach(){
        missing.betterApproach(n, arr);
    }

}
