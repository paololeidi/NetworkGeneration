package org.example;

import org.example.networks.Merge;
import org.example.networks.Pipeline;
import org.example.networks.Split;
import org.example.networks.complex.RandomNetwork;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Stream> availableStreams = new ArrayList<Stream>();
        Stream stressStream = new Stream("Stress");
        availableStreams.add(stressStream);
        Pipeline p = new Pipeline(stressStream);
        System.out.println(p);
        Stream weightStream = new Stream("Weight");
        availableStreams.add(weightStream);
        Merge m = new Merge(stressStream,weightStream);
        System.out.println(m);
        Split s = new Split(stressStream);
        System.out.println(s);

        Stream temperatureStream = new Stream("Temperature");
        availableStreams.add(temperatureStream);
        Stream noiseStream = new Stream("Noise");
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