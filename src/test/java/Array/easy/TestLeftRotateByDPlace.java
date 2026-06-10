package Array.easy;
import org.example.array.exercice.easy.LeftRotateByDPlace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLeftRotateByDPlace {
    int[] input = {1, 2, 3, 4, 5, 6, 7};
    int k = 2;

    int[] output = {6, 7, 1, 2, 3, 4, 5};
    LeftRotateByDPlace leftRotate;

    @BeforeEach
    public void setUp(){
        this.leftRotate = new LeftRotateByDPlace();
    }

    @Test
    public void testFirstImplementation(){
        leftRotate.firstImplementation(input, k);
    }

    @Test
    public void testSecondImplementationInPlace(){
        leftRotate.secondImplementationInPlace(input, k);
    }

    @Test
    public void testOptimalApproach(){
        leftRotate.betterOptimal(input, k);
    }

}
