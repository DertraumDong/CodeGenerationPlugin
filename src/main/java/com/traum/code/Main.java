package com.traum.code;

public class Main {

    public static void main(String[] args) throws Exception {
        GenerationUtil generationUtil = GenerationUtil.init(
                "metadate",
                "com.d.main",
                "/com/d/main",
                "元数据",
                "jdbc:mysql://127.0.0.1:3306/traum?serverTimezone=UTC",
                "traum",
                "123456",
                "com.mysql.cj.jdbc.Driver",
                "D:/demo1/");
        generationUtil.generate();
    }
}
