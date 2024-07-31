package org.example;

import org.example.networks.Merge;
import org.example.networks.Pipeline;
import org.example.networks.Split;

public class Main {
    public static void main(String[] args) {
        Stream stressStream = new Stream("Stress");
        Pipeline p = new Pipeline(stressStream);
        System.out.println(p);
        Stream weightStream = new Stream("Weight");
        Merge m = new Merge(stressStream,weightStream);
        System.out.println(m);
        Split s = new Split(stressStream);
        System.out.println(s);
    }

}