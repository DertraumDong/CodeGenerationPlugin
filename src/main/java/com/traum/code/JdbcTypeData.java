package com.traum.code;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 名称：jdbc映射类
 * 阐述：
 *
 * @author Administrator
 * @date 2020/4/3 0:40
 */
public class JdbcTypeData {

    private static Map<Integer, String> typeToName = new HashMap();
    private static Map<String, Integer> nameToType;

    private static Map<Integer, String> javaTypeMap = new HashMap();

    static {
// "ARRAY",
        javaTypeMap.put(2003, Object.class.getSimpleName());
        // "BIGINT",
        javaTypeMap.put(-5, Long.class.getSimpleName());
        //"BINARY",
        javaTypeMap.put(-2, "byte[]");
        //"BIT"
        javaTypeMap.put(-7, Boolean.class.getSimpleName());
        // "BLOB",
        javaTypeMap.put(2004,  "byte[]");
        // "BOOLEAN",
        javaTypeMap.put(16, Boolean.class.getSimpleName());
        // "CHAR",
        javaTypeMap.put(1,  String.class.getSimpleName());
        // "CLOB",
        javaTypeMap.put(2005,  String.class.getSimpleName());
        // "DATALINK",
        javaTypeMap.put(70,  Object.class.getSimpleName());
        // "DATE",
        javaTypeMap.put(91,  Date.class.getSimpleName());
        // "DISTINCT",
        javaTypeMap.put(2001,  Object.class.getSimpleName());
        // "DOUBLE",
        javaTypeMap.put(8, Double.class.getSimpleName());
        // "FLOAT",
        javaTypeMap.put(6,  Double.class.getSimpleName());
        // "INTEGER",
        javaTypeMap.put(4,  Integer.class.getSimpleName());
        //  "JAVA_OBJECT",
        javaTypeMap.put(2000, Object.class.getSimpleName());
        // "LONGNVARCHAR",
        javaTypeMap.put(-16,  String.class.getSimpleName());
        // "LONGVARBINARY",
        javaTypeMap.put(-4,  "byte[]");
        //  "LONGVARCHAR",
        javaTypeMap.put(-1, String.class.getSimpleName());
        //  "NCHAR",
        javaTypeMap.put(-15, String.class.getSimpleName());
        //  "NCLOB",
        javaTypeMap.put(2011, String.class.getSimpleName());
        // "NVARCHAR",
        javaTypeMap.put(-9,  String.class.getSimpleName());
        // "NULL",
        javaTypeMap.put(0,  Object.class.getSimpleName());
        // "OTHER",
        javaTypeMap.put(1111,  Object.class.getSimpleName());
        // "REAL",
        javaTypeMap.put(7,  Float.class.getSimpleName());
        //  "REF",
        javaTypeMap.put(2006, Object.class.getSimpleName());
        // "SMALLINT",
        javaTypeMap.put(5,  Short.class.getSimpleName());
        // "STRUCT",
        javaTypeMap.put(2002,  Object.class.getSimpleName());
        //  "TIME",
        javaTypeMap.put(92,Date.class.getSimpleName());
        // "TIMESTAMP",
        javaTypeMap.put(93, Date.class.getSimpleName());
        // "TINYINT",
        javaTypeMap.put(-6,  Byte.class.getSimpleName());
        //  "VARBINARY",
        javaTypeMap.put(-3, "byte[]");
        // "VARCHAR",
        javaTypeMap.put(12,  String.class.getSimpleName());

        typeToName.put(2003, "ARRAY");
        typeToName.put(-5, "BIGINT");
        typeToName.put(-2, "BINARY");
        typeToName.put(-7, "BIT");
        typeToName.put(2004, "BLOB");
        typeToName.put(16, "BOOLEAN");
        typeToName.put(1, "CHAR");
        typeToName.put(2005, "CLOB");
        typeToName.put(70, "DATALINK");
        typeToName.put(91, "DATE");
        typeToName.put(3, "DECIMAL");
        typeToName.put(2001, "DISTINCT");
        typeToName.put(8, "DOUBLE");
        typeToName.put(6, "FLOAT");
        typeToName.put(4, "INTEGER");
        typeToName.put(2000, "JAVA_OBJECT");
        typeToName.put(-4, "LONGVARBINARY");
        typeToName.put(-1, "LONGVARCHAR");
        typeToName.put(-15, "NCHAR");
        typeToName.put(2011, "NCLOB");
        typeToName.put(-9, "NVARCHAR");
        typeToName.put(-16, "LONGNVARCHAR");
        typeToName.put(0, "NULL");
        typeToName.put(2, "NUMERIC");
        typeToName.put(1111, "OTHER");
        typeToName.put(7, "REAL");
        typeToName.put(2006, "REF");
        typeToName.put(5, "SMALLINT");
        typeToName.put(2002, "STRUCT");
        typeToName.put(92, "TIME");
        typeToName.put(93, "TIMESTAMP");
        typeToName.put(-6, "TINYINT");
        typeToName.put(-3, "VARBINARY");
        typeToName.put(12, "VARCHAR");
        nameToType = new HashMap();
        nameToType.put("ARRAY", 2003);
        nameToType.put("BIGINT", -5);
        nameToType.put("BINARY", -2);
        nameToType.put("BIT", -7);
        nameToType.put("BLOB", 2004);
        nameToType.put("BOOLEAN", 16);
        nameToType.put("CHAR", 1);
        nameToType.put("CLOB", 2005);
        nameToType.put("DATALINK", 70);
        nameToType.put("DATE", 91);
        nameToType.put("DECIMAL", 3);
        nameToType.put("DISTINCT", 2001);
        nameToType.put("DOUBLE", 8);
        nameToType.put("FLOAT", 6);
        nameToType.put("INTEGER", 4);
        nameToType.put("JAVA_OBJECT", 2000);
        nameToType.put("LONGVARBINARY", -4);
        nameToType.put("LONGVARCHAR", -1);
        nameToType.put("NCHAR", -15);
        nameToType.put("NCLOB", 2011);
        nameToType.put("NVARCHAR", -9);
        nameToType.put("LONGNVARCHAR", -16);
        nameToType.put("NULL", 0);
        nameToType.put("NUMERIC", 2);
        nameToType.put("OTHER", 1111);
        nameToType.put("REAL", 7);
        nameToType.put("REF", 2006);
        nameToType.put("SMALLINT", 5);
        nameToType.put("STRUCT", 2002);
        nameToType.put("TIME", 92);
        nameToType.put("TIMESTAMP", 93);
        nameToType.put("TINYINT", -6);
        nameToType.put("VARBINARY", -3);
        nameToType.put("VARCHAR", 12);
    }

    public JdbcTypeData() {

    }

    public static String format(Integer integer){
        return javaTypeMap.get(integer);
    }

    public static Integer stringForInteger(String str){
        return nameToType.get(str);
    }

}
