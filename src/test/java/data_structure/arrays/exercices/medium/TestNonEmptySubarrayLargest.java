package data_structure.arrays.exercices.medium;
import org.example.data_structure.arrays.exercices.medium.NonEmptySubarrayLargest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestNonEmptySubarrayLargest {
    NonEmptySubarrayLargest nonEmpty;

    int[] data = new int[]{4, -1, 2, -7, 3, 4};
    int output = 7;

    @BeforeEach
    public void setUp(){
        this.nonEmpty = new NonEmptySubarrayLargest();
    }

    @Test
    public void testBrutForce(){
        Assertions.assertEquals(output, this.nonEmpty.brutForce(data));
    }

    @Test
    public void testTryKadane(){
        Assertions.assertEquals(output, this.nonEmpty.kadaneSolution(data));
    }
}
