package data_structure.map.implementation.separate_chaining;

import org.example.data_structure.set.implementation.MySet;
import org.example.data_structure.map.implementation.my_implementation.separate_chaining.MyMapSeparateChaining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class TestKeyIterator {
    private MyMapSeparateChaining<String, String> myMapSeparateChaining;

    @BeforeEach
    public void setUp(){
        this.myMapSeparateChaining = new MyMapSeparateChaining<>();
    }

    @Test
    public void testKeyIterator(){
        myMapSeparateChaining.put("Antoine", "Camarasa");
        myMapSeparateChaining.put("Hervet", "Renard");
        myMapSeparateChaining.put("Leo", "Faucon");
        myMapSeparateChaining.put("Anthony", "Reyre");
        myMapSeparateChaining.put("Thery", "Fouchter");
        myMapSeparateChaining.put("Romain", "Canuti");
        myMapSeparateChaining.put("Amory", "Rouault");
        myMapSeparateChaining.put("Pierre", "mendez");
        myMapSeparateChaining.put("Aurelien", "depreville");

        // De l'extérieur je peux typer qu'en set ?
        MySet<String> setOfKey = myMapSeparateChaining.keySet();

        Iterator<String> it =  setOfKey.iterator();
        while (it.hasNext()){
            String element = it.next();
            System.out.println(element);
        }
    }
}
