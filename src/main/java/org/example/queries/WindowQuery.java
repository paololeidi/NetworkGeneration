package org.example.queries;

import org.example.Stream;
import org.example.windows.Window;
import org.json.simple.JSONObject;

public class WindowQuery extends Query {

    // Fields
    private Stream inputStream;
    private Window window;
    private Stream outputStream;

    // Contructors
    public WindowQuery(){}

    public WindowQuery(Stream inputStream, Window window){
        this.inputStream = inputStream;
        this.window = window;
        String outputStream = inputStream.getName() + "_" + window.toString();
        this.outputStream = new Stream(outputStream);
    }

    // Getters & setters
    public Stream getInputStream() {
        return inputStream;
    }

    public Window getWindow() {
        return window;
    }

    public void setInputStream(Stream inputStream) {
        this.inputStream = inputStream;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Stream getOutputStream() { return outputStream; }

    public void setOutputStream(Stream outputStream) { this.outputStream = outputStream; }

    @Override
    public String toString() {
        return "WindowQuery{" +
                "inputStream=" + inputStream +
                ",\n window=" + window +
                ",\n outputStream=" + outputStream +
                '}';
    }

    @Override
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("type","window");
        jo.put("inputStream",inputStream.getName());
        jo.put("window",window.toJson());
        jo.put("outputStream",outputStream.getName());
        return jo;
    }
}
