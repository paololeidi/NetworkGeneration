package org.example.queries;

import org.example.DataType;
import org.example.Stream;
import org.example.windows.Window;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class WindowQuery extends Query {

    // Fields
    private Stream inputStream;
    private Window window;
    private Stream outputStream;
    private AggregateFunction aggFunction;

    // Contructors
    public WindowQuery(){}

    public WindowQuery(Stream inputStream, Window window, AggregateFunction aggFunction){
        this.inputStream = inputStream;
        this.window = window;
        String outputStream = inputStream.getName() + "_" + window.toString();
        HashMap<String, DataType> schema = new HashMap<>();
        schema.put("windowOpen",DataType.TIMESTAMP);
        schema.put("windowClose",DataType.TIMESTAMP);
        schema.put("id",DataType.INT);
        // TODO schema.put("max_TO_DETERMINE","type_TO_DETERMINE"); determine from the input schema
        this.outputStream = new Stream(outputStream,schema);
        this.aggFunction = aggFunction;
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
