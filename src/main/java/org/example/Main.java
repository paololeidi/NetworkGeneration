package org.example;

import org.example.networks.Merge;
import org.example.networks.Pipeline;
import org.example.networks.Split;
import org.example.networks.complex.RandomNetwork;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Stream> availableStreams = new ArrayList<Stream>();

        HashMap<String,DataType> stressSchema = new HashMap<>();
        stressSchema.put("id",DataType.INT);
        stressSchema.put("timestamp",DataType.TIMESTAMP);
        stressSchema.put("status",DataType.STRING);
        stressSchema.put("stressLevel",DataType.INT);
        Stream stressStream = new Stream("Stress",stressSchema);
        availableStreams.add(stressStream);

        Pipeline p = new Pipeline(stressStream);
        System.out.println(p);
        HashMap<String,DataType> weightSchema = new HashMap<>();
        weightSchema.put("id",DataType.INT);
        weightSchema.put("timestamp",DataType.TIMESTAMP);
        weightSchema.put("weight",DataType.FLOAT);
        Stream weightStream = new Stream("Weight",weightSchema);
        availableStreams.add(weightStream);

        Merge m = new Merge(stressStream,weightStream);
        System.out.println(m);
        Split s = new Split(stressStream);
        System.out.println(s);

        HashMap<String,DataType> temperatureSchema = new HashMap<>();
        temperatureSchema.put("id",DataType.INT);
        temperatureSchema.put("timestamp",DataType.TIMESTAMP);
        temperatureSchema.put("temperature",DataType.FLOAT);
        Stream temperatureStream = new Stream("Temperature",temperatureSchema);
        availableStreams.add(temperatureStream);

        HashMap<String,DataType> noiseSchema = new HashMap<>();
        noiseSchema.put("id",DataType.INT);
        noiseSchema.put("timestamp",DataType.TIMESTAMP);
        noiseSchema.put("noise",DataType.FLOAT);
        Stream noiseStream = new Stream("Noise",noiseSchema);
        availableStreams.add(noiseStream);

        RandomNetwork rn = new RandomNetwork(availableStreams);
        System.out.println(rn.toJson());
        JSONObject jo = rn.toJson();
        try {
            FileWriter file = new FileWriter("files/network.json");
            file.write(jo.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}