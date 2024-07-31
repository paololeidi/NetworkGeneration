package org.example.networks;

import org.example.RandomQueryFactory;
import org.example.Stream;
import org.example.queries.WindowQuery;

public class Split {
    private Stream inputStream;
    private WindowQuery query;
    private Stream outputStream1;
    private Stream outputStream2;

    public Split(Stream inputStream) {
        this.inputStream = inputStream;
        this.query = RandomQueryFactory.createRandomWindowQuery(inputStream);
        this.outputStream1 = new Stream(inputStream.getName() + "_" + query.getWindow().toString() + "_1");
        this.outputStream2 = new Stream(inputStream.getName() + "_" + query.getWindow().toString() + "_2");
    }

    @Override
    public String toString() {
        return "Split{" +
                "inputStream=" + inputStream +
                ",\n query=" + query +
                ",\n outputStream1=" + outputStream1 +
                ",\n outputStream2=" + outputStream2 +
                '}';
    }
}
