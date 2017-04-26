package com.bethecoder;

import com.bethecoder.ascii_table.ASCIITable;
import org.junit.Test;

import java.util.LinkedHashMap;

public class TableTest {

    @Test
    public void mapTest1(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("Key", "Value");
        map.put("id", "666");
        map.put("title", "Ascii Table");
        ASCIITable.getInstance().printTable(map);
    }
    @Test
    public void mapTest2(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("aa", "123");
        map.put("bb", "456");
        ASCIITable.getInstance().printTable(new String[]{"Key", "Value"}, map);
    }
}
