package com.traum.code;

public class Main {

    public static void main(String[] args) throws Exception {
        GenerationUtil generationUtil = GenerationUtil.init(
                "user",
                "com.traum.der",
                "/com/traum/der",
                "商品",
                "jdbc:mysql://127.0.0.1:3306/cd",
                "root",
                "621248",
                "com.mysql.jdbc.Driver",
                "G:/demo/");
        generationUtil.generate();
    }
}
