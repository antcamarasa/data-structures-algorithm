package Array.medium;
import org.example.array.exercice.medium.LongestSubArrayWithSumK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLongestSubArrayWithSumK {
    LongestSubArrayWithSumK longest;

    int[] arr = new int[]{2, 3, 5};
    int k = 5;

    int[] arr2 = new int[]{-1, 1, 1};
    int k2 = 1;

    int[] arr3 = new int[]{10, 1, 4, 5, 7, 1, 1};
    int k3 = 2;

    @BeforeEach
    public void setUp(){
        this.longest = new LongestSubArrayWithSumK();
    }


    @Test
    public void testFirstImplementation(){
        int rs = longest.findSumOfAllSubArray(arr3, k3);
        System.out.println(rs);
    }
}
