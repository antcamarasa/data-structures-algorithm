package data_structure.map.exercices;

import data_structure.map.helper.MapHelper;
import org.example.data_structure.map.exercices.CountingWordFrequency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TestCountingWordFrequency {
    CountingWordFrequency wordFrequency;
    MapHelper<String, Integer> mapHelper;

    @BeforeEach
    public void setUp(){
        wordFrequency = new CountingWordFrequency();
        mapHelper = new MapHelper<>();

    }

    @Test
    public void testWordFrequencyCount(){
        String documentTest = "Data structures and algorithms are essential for efficient programming. "
                + "In Java, a Map is the perfect data structure to count word frequencies! "
                + "Java is fast, powerful, and widely used for implementing complex algorithms. "
                + "Remember to normalize your text: convert everything to lowercase, remove punctuation, "
                + "and then split the string into individual words. Testing algorithms with good data "
                + "helps ensure your data structure handles edges cases correctly.";

        Map<String, Integer> wordFrequencyResult = wordFrequency.wordFrequencyCount(documentTest);
        mapHelper.helperForDisplayMap(wordFrequencyResult);

        System.out.println();
        System.out.println();
        Map<String, Integer> maxWordFrequency = wordFrequency.getMaxOccurence(wordFrequencyResult);
        mapHelper.helperForDisplayMap(maxWordFrequency);
    }
}
