package org.example.networks;

import org.example.SPE;
import org.example.Stream;
import org.example.queries.Query;
import org.example.queries.WindowQuery;

public class Split {
    private Stream inputStream;
    private WindowQuery query1;
    private SPE query1SPE;
    private Stream intermediateStream;
    private WindowQuery query2;
    private SPE query2SPE;
    private WindowQuery query3;
    private SPE query3SPE;
    private Stream outputStream1;
    private Stream outputStream2;

    public Split(Stream inputStream) {
        this.inputStream = inputStream;
        this.query1 = Query.getRandomWindowQuery(inputStream);
        this.intermediateStream = query1.getOutputStream();
        this.query2 = Query.getRandomWindowQuery(intermediateStream);
        this.query3 = Query.getRandomWindowQuery(intermediateStream);
        outputStream1 = query2.getOutputStream();
        outputStream2 = query3.getOutputStream();
        this.query1SPE = SPE.getRandomSystem();
        this.query2SPE = SPE.getRandomSystem();
        this.query3SPE = SPE.getRandomSystem();
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
