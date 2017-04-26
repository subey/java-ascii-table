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
    @Test
    public void mapTest3(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("aa", "123");
        map.put("bb", "456");
        ASCIITable.getInstance().printTable("Header", map);
    }
    @Test
    public void mapTest4(){
    
        String [] header = { "User Name",  "Salary"};

        String[][] data = {
                { "Ram", "2000" },
                { "Sri", "12000" },
        };

        String t = ASCIITable.getInstance().getTable(header, data);
        System.out.println(ASCIITable.getInstance().addFullHeader("New header", t));
    }
    @Test
    public void mapTest5(){

        String [] header = { "User Name",  "Salary"};

        String[][] data = {
                { "Ram", "2000" },
                { "Sri", "12000" },
        };

        String t = ASCIITable.getInstance().getTable(header, data);
        System.out.println(ASCIITable.getInstance().replaceToFullHeader("New header", t));
    }
    @Test
    public void inlineTabs(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("aa", "123");
        map.put("bb", "456");
        String t1 = ASCIITable.getInstance().getTable(new String[]{"Key", "Value"}, map);

        map = new LinkedHashMap<>();
        map.put("aa", "123");
        String t2 = ASCIITable.getInstance().getTable(new String[]{"Key", "Value"}, map);

        ASCIITable.getInstance().printInlineString(t1,t2, " ");
    }
}
