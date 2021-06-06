package com.dant.entity.link;

import java.util.ArrayList;
import java.util.List;

public class IndexLink {
    /*partie deserialisé*/


    private String name;
    private List<String> columns;

    public IndexLink(){
        columns = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
