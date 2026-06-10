package Array.medium;

import org.example.array.exercice.medium.SortArrayOf0s1s2s;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestSortArrayOf0s1s2s {
        SortArrayOf0s1s2s SortArr;
        int[] input = new int[]{1, 0, 2, 1, 0};
        int[] input2 = new int[]{0, 1, 2, 0, 1, 2};
        int[] output = new int[]{0, 0, 1, 1, 1};
        @BeforeEach
        public void setUp(){
            this.SortArr = new SortArrayOf0s1s2s();
        }

        @Test
        public void brutForceTest(){
            SortArr.brutForce(input);
            //System.out.println(Arrays.toString(input));
        }

        @Test
        public void brutForceTestV2(){
            SortArr.deutchNationalFlag(input);
            System.out.println(Arrays.toString(input));
        }

        @Test
        public void dutchNationalFlag(){
            SortArr.deutchNationalFlagInstruction(input);
            System.out.println(Arrays.toString(input));
        }

        @Test
        public void dutchNationalFlagSecond(){
            SortArr.deutchNationalFlagSecond(input2);
            System.out.println(Arrays.toString(input2));
        }

}
