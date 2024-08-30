package org.example.networks;

import org.example.SPE;
import org.example.Stream;
import org.example.queries.AggregateFunction;
import org.example.queries.JoinQuery;
import org.example.queries.WindowQuery;
import org.example.windows.HoppingWindow;
import org.example.windows.TumblingWindow;

public class Merge {
    private final Stream inputStream1;
    private final Stream inputStream2;
    private final WindowQuery windowQuery1; // Tumbling(2s)
    private final WindowQuery windowQuery2; // Hopping(4s,2s)
    private final JoinQuery joinQuery;
    private final SPE windowQuery1SPE;
    private final SPE windowQuery2SPE;
    private final SPE joinQuerySPE;

    public Merge(Stream inputStream1, Stream inputStream2){
        this.inputStream1 = inputStream1;
        this.inputStream2 = inputStream2;
        this.windowQuery1 = new WindowQuery(inputStream1,new TumblingWindow(2),AggregateFunction.MAX);
        this.windowQuery2 = new WindowQuery(inputStream2,new HoppingWindow(4,2),AggregateFunction.MAX);
        this.joinQuery = new JoinQuery(windowQuery1.getOutputStream(),windowQuery2.getOutputStream(),10);
        this.windowQuery1SPE = SPE.getRandomSystem();
        this.windowQuery2SPE = SPE.getRandomSystem();
        this.joinQuerySPE = SPE.getRandomSystem();
    }

    @Override
    public String toString() {
        return "Merge{" +
                "inputStream1=" + inputStream1 +
                ",\n inputStream2=" + inputStream2 +
                ",\n windowQuery1=" + windowQuery1 +
                ",\n windowQuery2=" + windowQuery2 +
                ",\n joinQuery=" + joinQuery +
                ",\n query1SPE=" + windowQuery1SPE +
                ",\n query2SPE=" + windowQuery2SPE +
                ",\n joinQuerySPE=" + joinQuerySPE +
                '}';
    }
}
