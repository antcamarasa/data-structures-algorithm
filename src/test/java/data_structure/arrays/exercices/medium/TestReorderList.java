package data_structure.arrays.exercices.medium;
import org.example.data_structure.arrays.exercices.medium.ReorderList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReorderList {
    ReorderList reorder;
    int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
    int[] output = new int[]{0, 6, 1, 5, 2, 4, 3};

    int[] arr2 = new int[]{1, 2, 3, 4};
    int[] output2 = new int[]{1, 4, 2, 3};

    @BeforeEach
    public void setUp(){
        this.reorder = new ReorderList();
    }

    @Test
    public void testSort(){
        reorder.better(arr);
    }
}
