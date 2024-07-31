package org.example.networks;

import org.example.Stream;
import org.example.queries.WindowQuery;
import org.example.SPE;
import org.example.windows.HoppingWindow;
import org.example.windows.SlidingWindow;
import org.example.windows.TumblingWindow;

public class Pipeline {
    private final Stream inputStream;
    private final WindowQuery query1; // Sliding(2s)
    private final WindowQuery query2; // Hopping(4s,2s)
    private final WindowQuery query3; // tumbling(10s)
    private final SPE query1SPE;
    private final SPE query2SPE;
    private final SPE query3SPE;

    public Pipeline(Stream inputStream){
        this.inputStream = inputStream;
        query1 = new WindowQuery(inputStream,new SlidingWindow(2));
        query2 = new WindowQuery(query1.getOutputStream(),new HoppingWindow(4,2));
        query3 = new WindowQuery(query2.getOutputStream(),new TumblingWindow(10));
        this.query1SPE = SPE.getRandomSystem();
        this.query2SPE = SPE.getRandomSystem();
        this.query3SPE = SPE.getRandomSystem();
    }

    @Override
    public String toString() {
        return "Pipeline{" +
                "\ninputStream=" + inputStream +
                ",\n query1=" + query1 + ", query1System=" + query1SPE +
                ",\n query2=" + query2 + ", query2System=" + query2SPE +
                ",\n query3=" + query3 + ", query3System=" + query3SPE +
                '}';
    }
}
