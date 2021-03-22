package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String,ArrayList<String>> infoPersone = new HashMap<>();
        HashMap<String,ArrayList<String>> infoMacchine = new HashMap<>();

        infoPersone = readCSV("/home/svilupposw1000/Scrivania/JAVA/Git/java-nouri-arash/Read and Write csv/reference/Persone.csv");
        infoMacchine = readCSV("/home/svilupposw1000/Scrivania/JAVA/Git/java-nouri-arash/Read and Write csv/reference/Macchine.csv");
        for(String idPersona : infoPersone.keySet()) {
            for(String idMacchina : infoMacchine.keySet()) {
                if(idPersona.equals(infoMacchine.get(idMacchina).get(1)))
                    infoMacchine.get(idMacchina).add(infoPersone.get(idPersona).get(0));
            }
        }
        createCSV(infoMacchine);
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

    private static void createCSV(HashMap<String, ArrayList<String>> hashmapFile) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new File("/home/svilupposw1000/Scrivania/JAVA/Git/java-nouri-arash/Read and Write csv/reference/joinMacchinePersone.csv"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Id Auto");
            stringBuilder.append(',');
            stringBuilder.append(" Macchina");
            stringBuilder.append(',');
            stringBuilder.append(" Id proprietario");
            stringBuilder.append(',');
            stringBuilder.append(" Nome proprietario");
            stringBuilder.append('\n');
            for(String info : hashmapFile.keySet()) {
                stringBuilder.append(info);
                ArrayList<String> dataArrayList = new ArrayList<>();
                dataArrayList = hashmapFile.get(info);
                ArrayList<String> finalDataArrayList = dataArrayList;
                stringBuilder.append(',');
                dataArrayList.forEach(data -> {
                    stringBuilder.append(data);
                    if(data.equals(finalDataArrayList.get(finalDataArrayList.size() - 1)))
                        stringBuilder.append(' ');
                    else
                        stringBuilder.append(',');
                });
                stringBuilder.append('\n');
                }
            writer.write(stringBuilder.toString());

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
