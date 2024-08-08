package org.example.networks.complex;

import org.example.SPE;
import org.example.Stream;
import org.example.queries.Query;
import org.example.windows.Window;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class RandomNetwork {
    Query query1;
    Query query2;
    Query query3;
    private final SPE query1SPE;
    private final SPE query2SPE;
    private final SPE query3SPE;

    public RandomNetwork(ArrayList<Stream> availableStreams){
        query1 = Query.getRandomQuery(availableStreams);
        query2 = Query.getRandomQuery(query1.getOutputStream(),availableStreams);
        query3 = Query.getRandomQuery(query2.getOutputStream(),availableStreams);
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

    public JSONObject toJson(){
        JSONObject jo = new JSONObject();
        JSONObject query1JO = query1.toJson();
        query1JO.put("SPE",query1SPE);
        JSONObject query2JO = query2.toJson();
        query2JO.put("SPE",query2SPE);
        JSONObject query3JO = query3.toJson();
        query3JO.put("SPE",query3SPE);
        jo.put("query1",query1JO);
        jo.put("query2",query2JO);
        jo.put("query3",query3JO);
        return jo;
    }
}
