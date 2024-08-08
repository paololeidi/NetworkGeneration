package org.example.windows;

import org.json.simple.JSONObject;

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

    @Override
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("type","hopping");
        jo.put("sizeSeconds",windowSizeSeconds);
        jo.put("slideSeconds",windowSlideSeconds);
        return jo;
    }
}
