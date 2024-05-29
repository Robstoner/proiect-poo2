package org.unibuc.utils;

import org.unibuc.entities.Artwork;
import org.unibuc.entities.Book;
import org.unibuc.services.LibraryService;

import java.io.*;
import java.util.Arrays;
import java.util.UUID;

public class CSVUtils {
    private static CSVUtils instance;
    private static final String path = "src/main/resources/library.csv";

    private CSVUtils() {
    }

    public static CSVUtils getInstance() {
        if (instance == null) {
            instance = new CSVUtils();
        }
        return instance;
    }

    public void saveData(LibraryService libraryService) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Book book : libraryService.getBooks().values()) {
                writer.write(book.toCSV());
                writer.newLine();
            }
            for (Artwork artwork : libraryService.getArtworks().values()) {
                writer.write(artwork.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    public void loadData(LibraryService libraryService) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String entityType = values[0];
                String[] entityValues = Arrays.copyOfRange(values, 1, values.length);

                if (entityType.equals(Book.class.getSimpleName())) {
                    Book book = (Book) Book.fromCSV(entityValues);
                    libraryService.getBooks().put(UUID.randomUUID(), book);
                } else if (entityType.equals(Artwork.class.getSimpleName())) {

                    Artwork artwork = (Artwork) Artwork.fromCSV(entityValues);
                    libraryService.getArtworks().put(UUID.randomUUID(), artwork);
                }
                else {
                    System.err.println("Unknown entity type: " + entityType);
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading from file: " + e.getMessage());
        }
    }
}
