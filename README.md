# JAVA ASCII Table
Fork of https://code.google.com/p/java-ascii-table/  
Open source under the [Apache 2.0 license](LICENSE.txt).

ASCII TABLE is a simple framework for generating ASCII tables printable in console and JSPs. It also provides enhanced APIs to get table buffer which can be rendered in Web pages.

Install via gradle:
-----
```gradle
repositories {
    maven { url 'http://maven.subey.net' }
}

dependencies {
    compile 'com.bethecoder:ascii_table:1.0-SNAPSHOT'
}
```

### Example1
```
String [] header = { "User Name",
            "Salary", "Designation",
            "Address", "Lucky#"
            };

String[][] data = {
            { "Ram", "2000", "Manager", "#99, Silk board", "1111"  },
            { "Sri", "12000", "Developer", "BTM Layout", "22222" },
            { "Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333" },
            { "Anu", "132000", "QA", "#22, Vizag", "4444444" },
            { "Sai", "62000", "Developer", "#3-3, Kakinada"  },
            { "Venkat", "2000", "Manager"   },
            { "Raj", "62000"},
            { "BTC"},
};


ASCIITable.getInstance().printTable(header, data);
```
It prints the following table in the console.
```
+-----------+--------+-------------+------------------------+---------+
| User Name | Salary | Designation |         Address        |  Lucky# |
+-----------+--------+-------------+------------------------+---------+
|       Ram |   2000 |     Manager |        #99, Silk board |    1111 |
|       Sri |  12000 |   Developer |             BTM Layout |   22222 |
|    Prasad |  42000 |        Lead | #66, Viaya Bank Layout |  333333 |
|       Anu | 132000 |          QA |             #22, Vizag | 4444444 |
|       Sai |  62000 |   Developer |         #3-3, Kakinada |         |
|    Venkat |   2000 |     Manager |                        |         |
|       Raj |  62000 |             |                        |         |
|       BTC |        |             |                        |         |
+-----------+--------+-------------+------------------------+---------+
```

### Example2
```
ASCIITableHeader[] headerObjs = {
          new ASCIITableHeader("User Name", ASCIITable.ALIGN_LEFT),
          new ASCIITableHeader("Salary"),
          new ASCIITableHeader("Designation", ASCIITable.ALIGN_CENTER),
          new ASCIITableHeader("Address", ASCIITable.ALIGN_LEFT),
          new ASCIITableHeader("Lucky#", ASCIITable.ALIGN_RIGHT),
};

String[][] data = {
          { "Ram", "2000", "Manager", "#99, Silk board", "1111"  },
          { "Sri", "12000", "Developer", "BTM Layout", "22222" },
          { "Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333" },
          { "Anu", "132000", "QA", "#22, Vizag", "4444444" },
          { "Sai", "62000", "Developer", "#3-3, Kakinada"  },
          { "Venkat", "2000", "Manager"   },
          { "Raj", "62000"},
          { "BTC"},
};


ASCIITable.getInstance().printTable(headerObjs, data);
```
It prints the following table in the console.
```
+-----------+--------+-------------+------------------------+---------+
| User Name | Salary | Designation |         Address        |  Lucky# |
+-----------+--------+-------------+------------------------+---------+
| Ram       |   2000 |   Manager   | #99, Silk board        |    1111 |
| Sri       |  12000 |  Developer  | BTM Layout             |   22222 |
| Prasad    |  42000 |     Lead    | #66, Viaya Bank Layout |  333333 |
| Anu       | 132000 |      QA     | #22, Vizag             | 4444444 |
| Sai       |  62000 |  Developer  | #3-3, Kakinada         |         |
| Venkat    |   2000 |   Manager   |                        |         |
| Raj       |  62000 |             |                        |         |
| BTC       |        |             |                        |         |
+-----------+--------+-------------+------------------------+---------+
```

### Example3
The following example shows rendering the ASCII Table in JSP using JSP Scriptlet.
```
String [] header = { "User Name",
            "Salary", "Designation",
            "Address", "Lucky#"
            };

String[][] data = {
            { "Ram", "2000", "Manager", "#99, Silk board", "1111"  },
            { "Sri", "12000", "Developer", "BTM Layout", "22222" },
            { "Prasad", "42000", "Lead", "#66, Viaya Bank Layout", "333333" },
            { "Anu", "132000", "QA", "#22, Vizag", "4444444" },
            { "Sai", "62000", "Developer", "#3-3, Kakinada"  },
            { "Venkat", "2000", "Manager"   },
            { "Raj", "62000"},
            { "BTC"},
};

<pre><%=ASCIITable.getInstance().getTable(header, data)%></pre>

+-----------+--------+-------------+------------------------+---------+
| User Name | Salary | Designation |         Address        |  Lucky# |
+-----------+--------+-------------+------------------------+---------+
| Ram       |   2000 |   Manager   | #99, Silk board        |    1111 |
| Sri       |  12000 |  Developer  | BTM Layout             |   22222 |
| Prasad    |  42000 |     Lead    | #66, Viaya Bank Layout |  333333 |
| Anu       | 132000 |      QA     | #22, Vizag             | 4444444 |
| Sai       |  62000 |  Developer  | #3-3, Kakinada         |         |
| Venkat    |   2000 |   Manager   |                        |         |
| Raj       |  62000 |             |                        |         |
| BTC       |        |             |                        |         |
+-----------+--------+-------------+------------------------+---------+
```

### Example4

The following example shows rendering the ASCII Table from database. It uses H2 database for getting BUG_STAT, USER table contents.
```
//Need to have h2-1.3.160.jar in classpath.
Class.forName("org.h2.Driver");
Connection conn = DriverManager.getConnection(
      "jdbc:h2:tcp://localhost/~/test", "sa", "");

//Print BUG_STAT table
IASCIITableAware asciiTableAware = new JDBCASCIITableAware(
                      conn, "select STATUS, COUNT from BUG_STAT");
ASCIITable.getInstance().printTable(asciiTableAware);

//Print USER table
asciiTableAware = new JDBCASCIITableAware(
                      conn, "select * from USER");
ASCIITable.getInstance().printTable(asciiTableAware);
```
It prints the following tables in the console.
```
+----------+-------+
|  STATUS  | COUNT |
+----------+-------+
|      NEW |     8 |
| ASSIGNED |    12 |
| RESOLVED |    16 |
|   REOPEN |     2 |
| VERIFIED |    16 |
|   CLOSED |     6 |
+----------+-------+

+----+----------+-----+------------+
| ID |   NAME   | AGE |   SALARY   |
+----+----------+-----+------------+
|  1 |   Sriram |   2 | 20,000,000 |
|  2 |      Anu |  28 |  4,800,000 |
|  3 | Sudhakar |  29 | 19,800,000 |
|  4 |   Charan |   3 | 10,000,000 |
|  5 |    Bunny |   2 | 16,000,000 |
+----+----------+-----+------------+
```

### Example5

The following example shows rendering the ASCII Table from list of java beans.
```
Employee stud = new Employee("Sriram", 2, "Chess", false, 987654321.21d);
Employee stud2 = new Employee("Sudhakar", 29, "Painting", true, 123456789.12d);
List<Employee> students = Arrays.asList(stud, stud2);

IASCIITableAware asciiTableAware =
        new CollectionASCIITableAware<Employee>(students,
                        //properties to read
                        "name", "age", "married", "hobby", "salary");
ASCIITable.getInstance().printTable(asciiTableAware);


asciiTableAware =
        new CollectionASCIITableAware<Employee>(students,
        //properties to read
        Arrays.asList("name", "age", "married", "hobby", "salary"),
        Arrays.asList("STUDENT_NAME", "HIS_AGE")); //custom headers

ASCIITable.getInstance().printTable(asciiTableAware);
```
It prints the following tables in the console.
```
+----------+-----+---------+----------+----------------+
|   NAME   | AGE | MARRIED |   HOBBY  |     SALARY     |
+----------+-----+---------+----------+----------------+
|   Sriram |   2 |   false |    Chess | 987,654,321.21 |
| Sudhakar |  29 |    true | Painting | 123,456,789.12 |
+----------+-----+---------+----------+----------------+

+--------------+---------+---------+----------+----------------+
| STUDENT_NAME | HIS_AGE | MARRIED |   HOBBY  |     SALARY     |
+--------------+---------+---------+----------+----------------+
|       Sriram |       2 |   false |    Chess | 987,654,321.21 |
|     Sudhakar |      29 |    true | Painting | 123,456,789.12 |
+--------------+---------+---------+----------+----------------+
```

### Example6
```
LinkedHashMap<String,String> map = new LinkedHashMap<>();
map.put("Key", "Value");
map.put("id", "666");
map.put("title", "Ascii Table");
ASCIITable.getInstance().printTable(map);

+-------+-------------+
|  Key  |    Value    |
+-------+-------------+
| id    | 666         |
| title | Ascii Table |
+-------+-------------+
```

### Example7
```
LinkedHashMap<String,String> map = new LinkedHashMap<>();
map.put("aa", "123");
map.put("bb", "456");
ASCIITable.getInstance().printTable(new String[]{"Key", "Value"}, map);

+-----+-------+
| Key | Value |
+-----+-------+
| aa  | 123   |
| bb  | 456   |
+-----+-------+
```

### Example8
```
LinkedHashMap<String,String> map = new LinkedHashMap<>();
map.put("aa", "123");
map.put("bb", "456");
String t1 = ASCIITable.getInstance().getTable(new String[]{"Key", "Value"}, map);

map = new LinkedHashMap<>();
map.put("aa", "123");
String t2 = ASCIITable.getInstance().getTable(new String[]{"Key", "Value"}, map);

ASCIITable.getInstance().printInlineString(t1,t2, " ");

+-----+-------+ +-----+-------+
| Key | Value | | Key | Value |
+-----+-------+ +-----+-------+
| aa  | 123   | | aa  | 123   |
| bb  | 456   | +-----+-------+
+-----+-------+
```

### Example9
```
LinkedHashMap<String,String> map = new LinkedHashMap<>();
map.put("aa", "123");
map.put("bb", "456");
ASCIITable.getInstance().printTable("Header", map);

+----------+
|  Header  |
+----+-----+
| aa | 123 |
| bb | 456 |
+----+-----+
```

### Example10
```
String [] header = { "User Name",  "Salary"};

String[][] data = {
    { "Ram", "2000" },
    { "Sri", "12000" },
};

String t = ASCIITable.getInstance().getTable(header, data);

System.out.println(ASCIITable.getInstance().addFullHeader("New header", t));
+--------------------+
|     New header     |
+--------------------+
| User Name | Salary |
+-----------+--------+
|       Ram |   2000 |
|       Sri |  12000 |
+-----------+--------+

System.out.println(ASCIITable.getInstance().replaceToFullHeader("New header", t));
+--------------------+
|     New header     |
+-----------+--------+
|       Ram |   2000 |
|       Sri |  12000 |
+-----------+--------+
```