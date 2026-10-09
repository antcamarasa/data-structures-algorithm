package data_structure.map.implementation.open_adressing;

import org.example.data_structure.map.implementation.my_implementation.open_adressing.MyMapOpenAddressing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestOpenAddressing {
    MyMapOpenAddressing<String, Integer> openAddressingMap;

    @BeforeEach
    public void setUp(){
        this.openAddressingMap = new MyMapOpenAddressing<>();
    }

    @Test
    public void testPutInsideMap(){
        openAddressingMap.put("Antoine", 19);
        openAddressingMap.put("Anthony", 21);
        openAddressingMap.put("fallen", 5);
        openAddressingMap.put("fallene", 5);
        System.out.println("TOTO");
        Assertions.assertEquals(null, openAddressingMap.getValue("hello"));
        Assertions.assertEquals(25, openAddressingMap.getValue("Leo"));
        Assertions.assertEquals(21, openAddressingMap.getValue("Anthony"));
    }


    @Test
    public void testRemoveValueInMap(){
        openAddressingMap.put("Antoine", 19);
        openAddressingMap.put("Anthony", 21);
        openAddressingMap.put("Antoinea", 37);

        openAddressingMap.remove("Anthony");
        var rs = openAddressingMap.getValue("Antoinea");
        System.out.println(rs);
    }
}
