package org.example.queries;

import org.example.Block;
import org.example.Stream;
import org.example.windows.HoppingWindow;
import org.example.windows.SlidingWindow;
import org.example.windows.TumblingWindow;
import org.example.windows.Window;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public abstract class Query extends Block {

    public Query(){}

    public abstract Stream getOutputStream();

    public abstract JSONObject toJson();

    public static WindowQuery getRandomWindowQuery(Stream inputStream) {
        Window window = getRandomWindow();
        AggregateFunction aggFunction = getRandomAggregateFunction();
        return new WindowQuery(inputStream, window, aggFunction);
    }

    private static AggregateFunction getRandomAggregateFunction() {
        Random random = new Random();
        int randomIndex = random.nextInt(3); // 0, 1, or 2
        AggregateFunction aggFunction = null;
        switch (randomIndex) {
            case 0:
                aggFunction = AggregateFunction.MAX;
                break;
            case 1:
                aggFunction = AggregateFunction.MIN;
                break;
            case 2:
                aggFunction = AggregateFunction.SUM;
                break;
        }
        return aggFunction;
    }

    private static Window getRandomWindow() {
        Random random = new Random();
        int randomIndex = random.nextInt(3); // 0, 1, or 2
        Window window = null;
        switch (randomIndex) {
            case 0:
                window = new TumblingWindow(2);
                break;
            case 1:
                window = new HoppingWindow(4,2);
                break;
            case 2:
                window = new SlidingWindow(10);
                break;
        }
        return window;
    }

    public static Query getRandomQuery(ArrayList<Stream> availableStreams){
        Random random = new Random();
        int randomIndex = random.nextInt(2); // 0, 1
        switch (randomIndex) {
            case 0:
                randomIndex = random.nextInt(availableStreams.size());
                Stream inputStream = availableStreams.get(randomIndex);
                return getRandomWindowQuery(inputStream);
            case 1:
                randomIndex = random.nextInt(availableStreams.size());
                Stream inputStream1 = availableStreams.get(randomIndex);
                int randomIndex2;
                do {
                    randomIndex2 = random.nextInt(availableStreams.size());
                } while (randomIndex2 == randomIndex);
                Stream inputStream2 = availableStreams.get(randomIndex2);
                return new JoinQuery(inputStream1, inputStream2,10);
        }
        return null;
    }

    public static Query getRandomQuery(Stream inputStream, ArrayList<Stream> availableStreams){
        Random random = new Random();
        int randomIndex = random.nextInt(2); // 0, 1
        switch (randomIndex) {
            case 0:
                return getRandomWindowQuery(inputStream);
            case 1:
                randomIndex = random.nextInt(availableStreams.size());
                Stream inputStream2;
                do {
                    inputStream2 = availableStreams.get(randomIndex);
                } while (inputStream2.equals(inputStream)); // TODO improve or remove stream check
                return new JoinQuery(inputStream, inputStream2,10);
        }
        return null;
    }
}
