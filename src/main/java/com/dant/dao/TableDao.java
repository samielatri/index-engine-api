package com.dant.dao;

import com.dant.entity.Table;

import javax.swing.text.TabExpander;
import java.util.ArrayList;
import java.util.List;

public class TableDao {

    private static List<Table> tables= new ArrayList<>();

    public void insert(Table table){
        tables.add(table);
    }

    public Table find(String name){
        for (Table table : tables){
            if(table.getTableName().equals(name)){
                return table;
            }
        }
        return null;
    }

    public static List<Table> getTables() {
        return tables;
    }

    public static void setTables(List<Table> tables) {
        TableDao.tables = tables;
    }
}
