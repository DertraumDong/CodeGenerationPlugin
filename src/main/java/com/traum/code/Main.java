package com.traum.code;

public class Main {

    public static void main(String[] args) throws Exception {
        GenerationUtil generationUtil = GenerationUtil.init(
                "brand",
                "com.traum.der",
                "/com/traum/der",
                "品牌",
                "jdbc:mysql://192.168.3.74:3306/ds?serverTimezone=UTC",
                "traum",
                "123456",
                "com.mysql.cj.jdbc.Driver",
                "D:/demo/");
        generationUtil.generate();
    }
}
