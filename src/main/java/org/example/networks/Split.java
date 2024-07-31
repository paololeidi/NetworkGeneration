package org.example.networks;

import org.example.RandomQueryFactory;
import org.example.Stream;
import org.example.queries.WindowQuery;

public class Split {
    private Stream inputStream;
    private WindowQuery query1;
    private Stream intermediateStream;
    private WindowQuery query2;
    private WindowQuery query3;
    private Stream outputStream1;
    private Stream outputStream2;

    public Split(Stream inputStream) {
        this.inputStream = inputStream;
        this.query1 = RandomQueryFactory.createRandomWindowQuery(inputStream);
        this.intermediateStream = query1.getOutputStream();
        this.query2 = RandomQueryFactory.createRandomWindowQuery(intermediateStream);
        this.query3 = RandomQueryFactory.createRandomWindowQuery(intermediateStream);
        outputStream1 = query2.getOutputStream();
        outputStream2 = query3.getOutputStream();
    }

    @Override
    public String toString() {
        return "Split{" +
                "inputStream=" + inputStream +
                ",\n query1=" + query1 +
                ",\n intermediateStream=" + intermediateStream +
                ",\n query2=" + query2 +
                ",\n query3=" + query3 +
                ",\n outputStream1=" + outputStream1 +
                ",\n outputStream2=" + outputStream2 +
                '}';
    }
}
