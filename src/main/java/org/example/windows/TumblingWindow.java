package org.example.windows;

public class TumblingWindow extends Window {
    private int windowSizeSeconds;

    public TumblingWindow(int windowSizeSeconds) {
        this.windowSizeSeconds = windowSizeSeconds;
    }

    public int getWindowSizeSeconds() {
        return windowSizeSeconds;
    }

    public void setWindowSizeSeconds(int windowSizeSeconds) {
        this.windowSizeSeconds = windowSizeSeconds;
    }

    @Override
    public String toString() {
        return "TUMBLING("+windowSizeSeconds+")";
    }
}
