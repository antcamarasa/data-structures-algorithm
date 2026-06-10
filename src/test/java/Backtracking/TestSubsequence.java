package Backtracking;

import org.example.backtracking.SubSet.Subsequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestSubsequence {
    Subsequence sub;
    String input;
    Set<String> output;

    String input2;
    Set<String> output2 = new LinkedHashSet<>();

    @BeforeEach
    public void setUp(){
        this.sub = new Subsequence();
        this.input = "abc";
        this.input2 = "abcd";

        this.output = new HashSet<>();
        this.output.add("a");
        this.output.add("b");
        this.output.add("c");
        this.output.add("ab");
        this.output.add("ac");
        this.output.add("bc");
        this.output.add("abc");

        this.output2 = Set.of(
                "", "a", "b", "c", "d",
                "ab", "ac", "ad", "bc", "bd", "cd",
                "abc", "abd", "acd", "bcd",
                "abcd"
        );
    }

    @Test
    public void shouldHaveAllSubset(){
        //Assertions.assertEquals(output, sub.brutForce(input));
        Assertions.assertEquals(output2, sub.brutForce(input2));
        //sub.brutForce(input2);
    }


    @Test
    public void isolateComplexSubset(){
        Assertions.assertEquals(output2, sub.recursiveSubset("abcd"));
    }

    @Test
    public void testDfs(){
        var result = sub.dfs2("abcd", 0, new ArrayList<>());
        for(String el : result){
            System.out.println(el);
        }
    }
}
