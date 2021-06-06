package com.dant.service;


import com.dant.dao.TableDao;
import com.dant.entity.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ParserCSV
        implements  MemorySystem {

    TableDao daoT= new TableDao();
    TableService tableService = new TableService();

    public ParserCSV() {

    }

    /**
     *
     * @param fileName String
     * @param nbLine int
     * @return boolean
     */

    public boolean loadFile (String tableName, InputStream file) {
        Table table = daoT.getTableDao().find(tableName);
        if(table == null) {
            System.out.println("table not found");
        }
        // get used memory
        final long initialUsedMemory = getUsedMemory();

        /* reading */
        String currentLine = "";
        int lineCounter = 0;

        BufferedReader bufferedReader = null;

        /* initializing stream and reader */
        InputStreamReader fileReader = new InputStreamReader(file);
        bufferedReader = new BufferedReader(fileReader);

        try {

            String line = bufferedReader.readLine();
            int position = line.getBytes().length+1;
            String [] row;
            HashMap<String,String> allRow = new HashMap<String,String>();

            while ((currentLine = bufferedReader.readLine()) != null) {
                row = currentLine.split(",");
                for (int i = 0; i < row.length;i++){
                    allRow.put(table.getColumns().get(i),row[i]);
                }
                tableService.insertIntoTable(table,allRow,String.valueOf(position));
                position+=currentLine.getBytes().length;
                // create record
                // add record to table
                lineCounter++;
            }
        } catch (Exception e){
            System.out.println(" Exception occurred while reading file ");
            e.printStackTrace();
            return false;
        }

        System.out.println(" Stopping at line number : " + lineCounter);

        try {
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(" Exception occurred while closing stream ");
            e.printStackTrace();
            return false;
        }


        final long endUsedMemory = getUsedMemory();
        final long usedMemory = (endUsedMemory - initialUsedMemory);

        // ... CONSTANT 1024 + formatter / 1024 / 1024
        final long tableSizeMB = usedMemory / 1024 / 1024;

        System.out.println(" Size of table = " + tableSizeMB + "MB");

        System.out.println("end");
        return true;
    }
}

