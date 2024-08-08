package org.example;

import java.util.HashMap;
import java.util.Map;

public class Stream {
    private String name;
    private HashMap<String,DataType> schema;

    public Stream(String name) {
        this.name = name;
    }

    public Stream(String name, HashMap<String,DataType> schema) {
        this.name = name;
        this.schema = schema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "name='" + name + '\'' +
                '}';
    }
}
