package org.example;

import org.example.queries.JoinQuery;
import org.example.queries.Query;
import org.example.queries.WindowQuery;
import org.example.windows.HoppingWindow;
import org.example.windows.SlidingWindow;
import org.example.windows.TumblingWindow;
import org.example.windows.Window;

import java.util.ArrayList;
import java.util.Random;

public class RandomQueryGenerator {

    public static WindowQuery getRandomWindowQuery(Stream inputStream) {
        Random random = new Random();
        int randomIndex = random.nextInt(3); // 0, 1, or 2
        Window window = new Window(){};
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
        return new WindowQuery(inputStream, window);
    }

    public static Query getRandomQuery(ArrayList<Stream> availableStreams){
        Query query = new Query(){};
        Random random = new Random();
        int randomIndex = random.nextInt(2); // 0, 1
        switch (randomIndex) {
            case 0:
                randomIndex = random.nextInt(availableStreams.size());
                Stream inputStream = availableStreams.get(randomIndex);
                query = getRandomWindowQuery(inputStream);
                break;
            case 1:
                randomIndex = random.nextInt(availableStreams.size());
                Stream inputStream1 = availableStreams.get(randomIndex);
                int randomIndex2;
                do {
                    randomIndex2 = random.nextInt(availableStreams.size());
                } while (randomIndex2 == randomIndex);
                Stream inputStream2 = availableStreams.get(randomIndex2);
                query = new JoinQuery(inputStream1, inputStream2,10);
                break;
        }
        return query;
    }

    public static Query getRandomQuery(Stream inputStream, ArrayList<Stream> availableStreams){
        Query query = new Query(){};
        Random random = new Random();
        int randomIndex = random.nextInt(2); // 0, 1
        switch (randomIndex) {
            case 0:
                query = getRandomWindowQuery(inputStream);
                break;
            case 1:
                randomIndex = random.nextInt(availableStreams.size());
                Stream inputStream2;
                do {
                    inputStream2 = availableStreams.get(randomIndex);
                } while (inputStream2.equals(inputStream)); // TODO improve or remove stream check
                query = new JoinQuery(inputStream, inputStream2,10);
                break;
        }
        return query;
    }
}
