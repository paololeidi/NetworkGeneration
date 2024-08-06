package org.example.networks.complex;

import org.example.RandomQueryGenerator;
import org.example.Stream;
import org.example.queries.Query;

import java.util.ArrayList;

public class RandomNetworkGenerator {
    Query query1;
    Query query2;
    Query query3;

    public RandomNetworkGenerator(ArrayList<Stream> availableStreams){
        query1 = RandomQueryGenerator.getRandomQuery(availableStreams);
        query2 = RandomQueryGenerator.getRandomQuery(query1.getOutputStream(),availableStreams);
        query3 = RandomQueryGenerator.getRandomQuery(query2.getOutputStream(),availableStreams);
    }

    @Override
    public String toString() {
        return "RandomNetwork{" +
                "query1=" + query1 +
                ",\n query2=" + query2 +
                ",\n query3=" + query3 +
                '}';
    }
}
