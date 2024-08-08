package org.example.windows;

import org.json.simple.JSONObject;

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

    @Override
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("type","tumbling");
        jo.put("sizeSeconds",windowSizeSeconds);
        return jo;
    }
}
