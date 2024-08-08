package org.example.windows;

import org.json.simple.JSONObject;

public abstract class Window {

    @Override
    public String toString() {
        return super.toString();
    }

    public abstract JSONObject toJson();
}
