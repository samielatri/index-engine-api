package com.dant.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Table {
    private String tableName;
    private List<String> columns = new ArrayList<String>();
    private HashMap<String, Index> indexes;
    //private List <Index> indexes;




    public Table(String tableName, List<String> columns) {
        this.tableName = tableName;
        this.columns = columns;
        indexes = new HashMap<String, Index>();
    }

    public HashMap<String, Index> getIndexes() {
        return indexes;
    }
    public void setIndexes(HashMap<String, Index> indexes) {
        this.indexes = indexes;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    /**
     * return true if indexes are valid, false if not
     * @param indexesToCheck List<String>
     * @return boolean
     */
    public boolean areInvalidIndexes(List<String> indexesToCheck) {
        return !columns.containsAll(indexesToCheck);
    }

    /**
     * return a list of invalid indexes, invalid indexes are defined by
     * the fact that columns does not exist with asme name
     * @param indexesToCheck List<String>
     * @return List<String>
     */
    public List<String> getInvalidIndexes(List<String> indexesToCheck) {
        List<String> invalidIndexes = new ArrayList<>();
        for(String indexToAdd : indexesToCheck) {
            if(!columns.contains(indexToAdd)){
                invalidIndexes.add(indexToAdd);
            }
        }
        return invalidIndexes;
    }

    public boolean existIndex(String colonne){
        return indexes.get(colonne)!=null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table)) return false;
        Table table = (Table) o;
        return getTableName().equals(table.getTableName()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTableName());
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", columns=" + columns +
                '}';
    }

}
