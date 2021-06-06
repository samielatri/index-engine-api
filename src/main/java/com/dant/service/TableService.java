package com.dant.service;

import com.dant.dao.TableDao;
import com.dant.entity.Index;
import com.dant.entity.Table;
import com.dant.entity.link.TableLink;

import java.util.HashMap;
import java.util.Set;

public class TableService {
    /*creer une table, modifier table ....*/
    /*methode creation de table*/
    TableDao daoT= new TableDao();
    public Table creationTable(TableLink tableLink) throws Exception {
        /*verifier si la table n'existe pas déjà avant si c'est le cas throw des execption*/
        Table table = daoT.find(tableLink.getName());
        if (table!=null){
            throw new Exception();
        }
        table = new Table(tableLink.getName(), tableLink.getColumns());/*creer objet table avec TableLink, new Table(nomTablelink, liste colonne)*/
        daoT.insert(table); /*ajouter dans une liste de table avec insert de TableDao*/
        return table;
    }

    public void addIndex(Index index, Table table){
        table.getIndexes().put(index.getColonne(),index);
    }

    public void insertIntoTable(Table table, HashMap<String,String> line, String position ){
        Set<String> keys = table.getIndexes().keySet();
        for(String key : keys){
            String value = line.getOrDefault(key,"NULL");
            table.getIndexes().get(key).insert(value,position);
        }
    }

}
