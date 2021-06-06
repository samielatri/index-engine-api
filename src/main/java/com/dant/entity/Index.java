package com.dant.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Index {
    private String colonne;
    private HashMap<String, Set<String>> data;

    public Index(String colonne) {
        this.colonne = colonne;
        data=new HashMap<>();
    }

    public String getColonne() {
        return colonne;
    }

    public void setColonne(String colonne) {
        this.colonne = colonne;
    }

    public HashMap<String, Set<String>> getData() {
        return data;
    }

    public void setData(HashMap<String, Set<String>> data) {
        this.data = data;
    }

    //methode recherche d'index, verifier la hash map
    public Set<String> find(String key) {
        return data.get(key);
    }

    public void insert(String key, String value) {
        if (data.get(key)==null){
            Set <String> dataset = new HashSet<String>();
            dataset.add(value);
            data.put(key, dataset);
        }else{
            data.get(key).add(value);
        }

    }
}
