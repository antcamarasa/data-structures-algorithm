package data_structure.set.implementation;

import org.example.data_structure.set.implementation.MyHashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class testMySetIterator<T> {
    private MyHashSet<String> myHashSet;
    private Iterator<String> it;

    @BeforeEach
    public void setUp(){
        myHashSet = new MyHashSet<String>();
    }

    @Test
    public void test(){
        myHashSet.add("Antoine");
        myHashSet.add("Leo");
        myHashSet.add("Enzo");
        myHashSet.add("Lorenzo");
        myHashSet.add("Théo");
        myHashSet.add("Fernand");
        myHashSet.add("Tristant");
        myHashSet.add("Ernandez");
        myHashSet.add("Zili");
        myHashSet.add("Emile");

        it = myHashSet.iterator();

        while(it.hasNext()){
            var rs = it.next();
            System.out.println(rs);
        }
        System.out.println("End of iterator");
    }


}
