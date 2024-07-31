package org.example.windows;

public class HoppingWindow extends Window {
    private int windowSizeSeconds;
    private int windowSlideSeconds;

    public HoppingWindow(int windowSizeSeconds, int windowSlideSeconds) {
        this.windowSizeSeconds = windowSizeSeconds;
        this.windowSlideSeconds = windowSlideSeconds;
    }

    public int getWindowSizeSeconds() {
        return windowSizeSeconds;
    }

    public void setWindowSizeSeconds(int windowSizeSeconds) {
        this.windowSizeSeconds = windowSizeSeconds;
    }

    public int getWindowSlideSeconds() {
        return windowSlideSeconds;
    }

    public void setWindowSlideSeconds(int windowSlideSeconds) {
        this.windowSlideSeconds = windowSlideSeconds;
    }

    @Override
    public String toString() {
        return "HOPPING("+windowSizeSeconds+","+windowSlideSeconds+")";
    }
}
