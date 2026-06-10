package Backtracking;
import org.example.backtracking.GenerateParenthesis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestGenerateParenthesis {
    GenerateParenthesis parenthesis;

    @BeforeEach
    public void setUp(){
        this.parenthesis = new GenerateParenthesis();
    }
    @Test
    public void testFirstIteration(){
        List<String> output = new ArrayList<>();
        output.add("((()))");
        output.add("(()())");
        output.add("(())()");
        output.add("()(())");
        output.add("()()()");
        int n = 3;
        Assertions.assertEquals(output, parenthesis.firstIteration(n));
    }
    @Test
    public void testBrutForce(){
        Set<String> output = new HashSet<>();
        output.add("()()()");
        output.add("(()())");
        output.add("(())()");
        output.add("()(())");
        output.add("((()))");
        int n = 3;
        Assertions.assertEquals(output, parenthesis.brutForce(3));
    }

    // Correction
    @Test
    public void testCorrectionBrutForce(){
        Assertions.assertTrue(parenthesis.isValid("()"));
        Assertions.assertFalse(parenthesis.isValid(")("));
        Assertions.assertTrue(parenthesis.isValid("()()()"));
    }

    @Test
    public void testCorrectionBrutForce2(){
        var rs  = parenthesis.brutForceOther(4);
        var rs2 = parenthesis.putItTogether(rs, 4);
        for(String el : rs2){
            System.out.println(el);
        }
    }
}
