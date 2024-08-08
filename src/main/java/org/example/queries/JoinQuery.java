package org.example.queries;

import org.example.DataType;
import org.example.Stream;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class JoinQuery extends Query {

    // Fields
    private Stream inputStream1;
    private Stream inputStream2;
    private int joinWithinSeconds;



    private Stream outputStream;

    // Constructors

    public JoinQuery(){}

    public JoinQuery(Stream inputStream1, Stream inputStream2, int joinWithinSeconds) {
        this.inputStream1 = inputStream1;
        this.inputStream2 = inputStream2;
        this.joinWithinSeconds = joinWithinSeconds;
        String name = inputStream1.getName() +
                "_JOIN_" + inputStream2.getName() +
                "_WITHIN_" +
                joinWithinSeconds + "_SECONDS";
        HashMap<String, DataType> schema = new HashMap<>();
        // TODO determine schema
        this.outputStream = new Stream(name,schema);
    }

    // Getters & setters
    public Stream getInputStream1() {
        return inputStream1;
    }

    public Stream getInputStream2() {
        return inputStream2;
    }

    public int getJoinWithinSeconds() {
        return joinWithinSeconds;
    }

    public void setInputStream1(Stream inputStream1) {
        this.inputStream1 = inputStream1;
    }

    public void setInputStream2(Stream inputStream2) {
        this.inputStream2 = inputStream2;
    }

    public void setJoinWithinSeconds(int joinWithinSeconds) {
        this.joinWithinSeconds = joinWithinSeconds;
    }

    @Override
    public Stream getOutputStream() {
        return outputStream;
    }

    @Override
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("type","join");
        jo.put("inputStream1",inputStream1.getName());
        jo.put("inputStream2",inputStream2.getName());
        jo.put("joinWithinSeconds",joinWithinSeconds);
        jo.put("outputStream",outputStream.getName());
        return jo;
    }

    public void setOutputStream(Stream outputStream) {
        this.outputStream = outputStream;
    }
    @Override
    public String toString() {
        return "JoinQuery{" +
                "inputStream1=" + inputStream1 +
                ",\n inputStream2=" + inputStream2 +
                ",\n joinWithinSeconds=" + joinWithinSeconds +
                ",\n outputStream=" + outputStream +
                '}';
    }
}
