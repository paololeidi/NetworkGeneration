package org.example.networks.complex;

import org.example.RandomQueryGenerator;
import org.example.SPE;
import org.example.Stream;
import org.example.queries.Query;

import java.util.ArrayList;

public class RandomNetwork {
    Query query1;
    Query query2;
    Query query3;
    private final SPE query1SPE;
    private final SPE query2SPE;
    private final SPE query3SPE;

    public RandomNetwork(ArrayList<Stream> availableStreams){
        query1 = RandomQueryGenerator.getRandomQuery(availableStreams);
        query2 = RandomQueryGenerator.getRandomQuery(query1.getOutputStream(),availableStreams);
        query3 = RandomQueryGenerator.getRandomQuery(query2.getOutputStream(),availableStreams);
        this.query1SPE = SPE.getRandomSystem();
        this.query2SPE = SPE.getRandomSystem();
        this.query3SPE = SPE.getRandomSystem();
    }

    @Override
    public String toString() {
        return "RandomNetworkGenerator{" +
                "query1=" + query1 + ", query1SPE=" + query1SPE +
                ",\n query2=" + query2 + ", query2SPE=" + query2SPE +
                ",\n query3=" + query3 + ", query3SPE=" + query3SPE +
                '}';
    }
}
