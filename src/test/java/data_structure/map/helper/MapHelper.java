package data_structure.map.helper;

import java.util.Map;

public class MapHelper<K, V> {
    public void helperForDisplayMap(Map<K, V> resultMap) {
        for (Map.Entry<K, V> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
