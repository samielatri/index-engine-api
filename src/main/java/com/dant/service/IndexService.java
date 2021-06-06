package com.dant.service;

import com.dant.dao.TableDao;
import com.dant.entity.Index;
import com.dant.entity.link.IndexLink;
import com.dant.entity.Table;
import com.dant.entity.link.QueryLink;
import com.dant.exception.InvalidIndexException;

import javax.ws.rs.NotFoundException;
import java.util.*;

public class IndexService {
    /*creation de l'index*/
    TableService tableService = new TableService();
    TableDao daoT= new TableDao();
    public Table creationIndex(IndexLink indexLink) throws Exception {
        /*verifier dans la table avec la methode find de TableDao si ya pas déjà le meme index*/
        Table table = daoT.find(indexLink.getName());
        if (table==null){
            throw new NotFoundException();
        }

        if(table.areInvalidIndexes(indexLink.getColumns())){
            throw new InvalidIndexException();
        }
        for (String colonne: indexLink.getColumns()){
            if(!table.existIndex(colonne))
                tableService.addIndex( new Index(colonne),table);/*ajouter dans la table */
        }

        return table;
    }


    public Set<String> find(QueryLink queryLink) throws InvalidIndexException {
        Table table = daoT.find(queryLink.getTableName());
        if (table==null){
            throw new NotFoundException();
        }
        if(table.areInvalidIndexes(new ArrayList<>(queryLink.getQuery().keySet()))){
            throw new InvalidIndexException();
        }
        if(table.areInvalidIndexes(queryLink.getColumns())){
            throw new InvalidIndexException();
        }
        List<Set<String>> all = new ArrayList<Set<String>>();
        for (Map.Entry<String,String> data : queryLink.getQuery().entrySet()){
            all.add(table.getIndexes().get(data.getKey()).find((String) data.getValue()));
        }

        return intersect(all);

    }

    //faire l'intersection de tous les set de la liste all et retourne un set
    public Set<String> intersect (List<Set<String>> list){
        Set<String> result= new HashSet<>();
        boolean first=true;
        for (Set set : list){
            if (first) {
                result.addAll(set);
                first = false;
            }else{
                result.retainAll(set);
            }
        }
        return result;

    }
}
