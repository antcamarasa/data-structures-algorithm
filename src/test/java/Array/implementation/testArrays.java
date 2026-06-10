package Array.implementation;
import org.example.array.implementation.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testArrays {
    Arrays<Integer> array;

    int[] arr = {1, 3, 5, 7, 9, 11};
    int target = 11;
    int output = 5;

    @BeforeEach
    public void setUp(){
        this.array = new Arrays<Integer>(arr.length);
        for(int i = 0; i < arr.length; i++){
            this.array.setValue(i, arr[i]);
        }
    }

    @Test
    public void testSetValue(){
        for (int i = 0; i < this.array.size(); i++){
            System.out.println(this.array.getValue(i));
        }
    }
}
