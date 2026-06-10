package Array.easy;

import org.example.array.exercice.easy.removeDuplicateInPlace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class TestRemoveDuplicateInPlace {
    removeDuplicateInPlace removeDuplicateInPlace;

    @BeforeEach
    public void setUp(){
        this.removeDuplicateInPlace = new removeDuplicateInPlace();
    }

    @Test
    public void test(){
        String[] arr = {"1","1","2","2","2","3","3"};
        String[] arr_2 = {"1", "1", "1", "2", "2", "3", "3", "3", "3", "4", "4"};

        String[] output = {"1","2","3","_","_","_","_"};
        String[] output_2 = {"1","2","3","4","_","_","_","_","_","_","_"};

       var rs = removeDuplicateInPlace.optimal(output_2);
        System.out.println(Arrays.toString(rs));
    };

}
