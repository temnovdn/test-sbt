package com.github.temnovdn.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitrytemnov on 16/10/15.
 */
public final class FileReader {

    static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);

    private FileReader() {
    }

    public static List<String[]> readFile(final String filepath) {
        final List<String[]> operations = new ArrayList<String[]>();

        BufferedReader br = null;
        String line = "";
        final String splitter = ";";

        try {
            br = new BufferedReader(new java.io.FileReader(filepath));
            while ((line = br.readLine()) != null) {
                final String[] row = line.split(splitter);
                operations.add(row);
            }
        } catch (FileNotFoundException e) {
            LOGGER.info(String.format("File %s not found", filepath));
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operations;
    }
}
