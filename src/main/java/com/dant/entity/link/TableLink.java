package com.dant.entity.link;

import java.util.ArrayList;
import java.util.List;

public class TableLink {
    /*partie pour déséraliser le json*/


    private String name;
    private List<String> columns;

    public TableLink(){
        columns = new ArrayList<>();
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
