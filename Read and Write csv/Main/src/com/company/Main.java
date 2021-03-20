package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String,ArrayList<String>> infoPersone = new HashMap<>();
        HashMap<String,ArrayList<String>> infoMacchine = new HashMap<>();

        infoPersone = readCSV("/Users/Arashn2y/Downloads/csv/reference/Persone.csv");
        infoMacchine = readCSV("/Users/Arashn2y/Downloads/csv/reference/Macchine.csv");
        System.out.println(infoPersone.toString());
        System.out.println(infoMacchine.toString());
        for(String idPersona : infoPersone.keySet()) {
            for(String idMacchina : infoMacchine.keySet()) {
                if(idPersona.equals(infoMacchine.get(idMacchina).get(1)))
                    infoMacchine.get(idMacchina).add(infoPersone.get(idPersona).get(0));
            }
        }
        System.out.println(infoMacchine.toString());
    }

    public static HashMap<String, ArrayList<String>> readCSV(String file) throws FileNotFoundException {
        String line ="";
        String splitBy = ",";
        ArrayList<String> firstList = new ArrayList<>();
        HashMap<String, ArrayList<String>> list = new HashMap<>();
        BufferedReader BufferReader = new BufferedReader(new FileReader(file));
        try {
            while ((line = BufferReader.readLine()) != null)
            {
                for(String element : line.split(splitBy)) {
                    firstList.add(element.trim());
                }

                String id = firstList.remove(0);
                if(isNumeric(id))
                    list.put(id, firstList);
                firstList = new ArrayList<>();
            }
        } catch (IOException error) {
            error.getMessage();
        }
        return list;
    }

    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}
