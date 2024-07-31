package org.example;

import java.util.Random;

public enum SPE {
    SPARK("Spark"),
    FLINK("Flink"),
    KSQLDB("ksqlDB"),
    RISINGWAVE("RisingWave");

    private final String name;


    SPE(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static SPE getRandomSystem() {
        Random random = new Random();
        Class<SPE> enumClass = SPE.class;
        int randomIndex = random.nextInt(enumClass.getEnumConstants().length);
        return enumClass.getEnumConstants()[randomIndex];
    }
}
