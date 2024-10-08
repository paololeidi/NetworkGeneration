package org.example.windows;

import org.json.simple.JSONObject;

public class SlidingWindow extends Window {
    private int windowSizeSeconds;
    private static final int windowSlideSeconds = 1;

    public SlidingWindow(int windowSizeSeconds) {
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
        return "SLIDING("+windowSizeSeconds+")";
    }

    @Override
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("type","sliding");
        jo.put("sizeSeconds",windowSizeSeconds);
        return jo;
    }
}
