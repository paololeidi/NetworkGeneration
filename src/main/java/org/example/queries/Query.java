package org.example.queries;

import org.example.Block;
import org.example.Stream;

public abstract class Query extends Block {

    public Query(){}

    public Stream getOutputStream(){ return null; }
}
