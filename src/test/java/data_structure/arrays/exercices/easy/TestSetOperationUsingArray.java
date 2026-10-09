package data_structure.arrays.exercices.easy;

import org.example.data_structure.arrays.exercices.easy.SetOperationUsingArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

public class TestSetOperationUsingArray {
    SetOperationUsingArray union;
    int[] arr1 = {1,1,3,4,5};
    int[] arr2 = {2,3,4,4,5};
    int[] output = {1,2,3,4,5};

    // ===================================
    int[] arr_3 = {};
    int[] arr_4 = {};
    int[] output_2 = {};

    @BeforeEach
    public void setup(){
        this.union = new SetOperationUsingArray();
    }

    @Test
    public void testUnionUsingSet(){
        Set<Integer> result = union.unionUsingSet(arr1, arr2);
        System.out.println("Result => " + result.toString());
    }

    @Test
    public void testUnionUsingMap(){
        var unionValue = union.unionUsingMap(arr1, arr2);
        System.out.println("Union value => " + Arrays.toString(unionValue));
    }

    @Test
    public void testTwoPointer(){
        union.twoPointer(arr1, arr2);
    }

    @Test
    public void testTwoPointerCorrection(){
        union.twoPointerCorrection(arr1, arr2);
    }

}
