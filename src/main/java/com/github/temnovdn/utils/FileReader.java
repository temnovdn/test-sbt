package com.github.temnovdn.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dmitrytemnov on 16/10/15.
 */
public class FileReader {

    public static ArrayList<String[]> readFile(final String filepath) {
        ArrayList<String[]> operations = new ArrayList<String[]>();

        BufferedReader br = null;
        String line = "";
        String splitter = ";";

        try {
            br = new BufferedReader(new java.io.FileReader(filepath));
            while ((line = br.readLine()) != null) {
                String[] row = line.split(splitter);
                operations.add(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return operations;
    }
}
