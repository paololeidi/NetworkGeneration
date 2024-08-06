package org.example;

import org.example.networks.Merge;
import org.example.networks.Pipeline;
import org.example.networks.Split;
import org.example.networks.complex.RandomNetworkGenerator;

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
        RandomNetworkGenerator rn = new RandomNetworkGenerator(availableStreams);
        System.out.println(rn);
    }

}