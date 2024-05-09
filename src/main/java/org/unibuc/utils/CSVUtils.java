package org.unibuc.utils;

import org.unibuc.entities.LibraryEntity;

import java.io.*;
import java.util.Map;
import java.util.UUID;

public class CSVUtils {
    public void saveData(String path, Map<UUID, LibraryEntity> data) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            for (LibraryEntity entity : data.values()) {
                writer.write(entity.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    public void loadData(String path) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading from file: " + e.getMessage());
        }
    }
}
