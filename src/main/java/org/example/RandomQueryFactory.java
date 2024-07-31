package org.example;

import org.example.queries.WindowQuery;
import org.example.windows.HoppingWindow;
import org.example.windows.SlidingWindow;
import org.example.windows.TumblingWindow;
import org.example.windows.Window;

import java.util.Random;

public class RandomQueryFactory {

    public static WindowQuery createRandomWindowQuery(Stream inputStream) {
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
}
