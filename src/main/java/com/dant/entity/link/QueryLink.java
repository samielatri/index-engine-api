package com.dant.entity.link;

import java.util.HashMap;
import java.util.List;

public class QueryLink {
    private String tableName;
    private HashMap<String,String> query;
    private List<String> columns;

    public QueryLink() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public HashMap<String, String> getQuery() {
        return query;
    }

    public void setQuery(HashMap<String, String> query) {
        this.query = query;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
