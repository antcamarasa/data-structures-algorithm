package data_structure.arrays.implementation;
import org.example.data_structure.arrays.implementation.MethodeNonGenerique;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testMethodNonGenerique {
    MethodeNonGenerique method;
    int[] arr = {1, 3, 5, 7, 9, 11};
    int target = 11;
    int output = 5;

    @BeforeEach
    public void setUp(){
        this.method = new MethodeNonGenerique();
    }

    @Test
    public void testBinarySearch(){
        var result = method.binarySearch(arr, target);
        System.out.println(result);
    }
}
