package org.unibuc;

import org.unibuc.entities.Artwork;
import org.unibuc.entities.Author;
import org.unibuc.entities.Book;
import org.unibuc.entities.Reader;
import org.unibuc.entities.enums.Genre;
import org.unibuc.entities.enums.Style;
import org.unibuc.services.LibraryService;
import org.unibuc.utils.CSVUtils;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class LibraryApp {

    public static void main(String[] args) {
        CSVUtils csvUtils = CSVUtils.getInstance();
        LibraryService libraryService = LibraryService.getInstance();

        csvUtils.loadData(libraryService);

        System.out.println("Saved data:");
        System.out.println("Books: " + libraryService.getBooks());
        System.out.println("Artworks: " + libraryService.getArtworks());

        libraryService.addAuthor(new Author(UUID.randomUUID(), "J. K. Rowling", Date.from(Instant.parse("1965-07-31T10:00:00.00Z")), "jkrowling@example.com"));
        libraryService.addAuthor(new Author(UUID.randomUUID(), "Stephen King", Date.from(Instant.parse("1947-09-21T10:00:00.00Z")), "stephenking@example.com"));

        libraryService.addBook(new Book(UUID.randomUUID(), "J. K. Rowling", Date.from(Instant.parse("1997-06-26T10:00:00.00Z")),
                "Harry Potter and the Philosopher's Stone", "The book that started it all", Genre.FANTASY,
                223, "0-7475-3269-9", "Bloomsbury Publishing", false));
        libraryService.addBook(new Book(UUID.randomUUID(), "Stephen King", Date.from(Instant.parse("1974-04-05T10:00:00.00Z")),
                "Carrie", "The book that started it all", Genre.HORROR, 199, "978-0-385-08695-0",
                "Doubleday", false));
        libraryService.addBook(new Book(UUID.randomUUID(), "Stephen King", Date.from(Instant.parse("1975-04-07T10:00:00.00Z")),
                "Salem's Lot", "The book that started it all", Genre.HORROR, 439, "978-0-385-08695-0",
                "Doubleday", false));

        libraryService.addAuthor(new Author(UUID.randomUUID(), "Leonardo da Vinci", Date.from(Instant.parse("1452-04-15T10:00:00.00Z")), "leodavinci@example.com"));

        libraryService.addArtwork(new Artwork(UUID.randomUUID(), "Leonardo da Vinci", Date.from(Instant.parse("1503-07-01T10:00:00.00Z")),
                "Mona Lisa", "The most famous painting in the world", Style.RENAISSANCE, 30, 40));
        libraryService.addArtwork(new Artwork(UUID.randomUUID(), "Leonardo da Vinci", Date.from(Instant.parse("1495-08-15T10:00:00.00Z")),
                "The Last Supper", "One of the most famous paintings in the world", Style.RENAISSANCE, 460, 880));

        libraryService.addReader(new Reader(UUID.randomUUID(), "John Doe", Date.from(Instant.parse("1990-01-01T10:00:00.00Z")), "reader1@example.com"));
        libraryService.addReader(new Reader(UUID.randomUUID(), "Jane Doe", Date.from(Instant.parse("1995-01-01T10:00:00.00Z")), "reader2@example.com"));

        try {
            libraryService.borrowBook(libraryService.getReaders().values().stream().findFirst().get().getId(),
                    libraryService.getBooks().values().stream().findFirst().get().getId());
            libraryService.borrowBook(libraryService.getReaders().values().stream().findFirst().get().getId(),
                    libraryService.getBooks().values().stream().skip(1).findFirst().get().getId());
        } catch(Exception e) {
            System.err.println("An error occurred while borrowing books: " + e.getMessage());
        }

        System.out.println("Updated data:");
        System.out.println("Books: " + libraryService.getBooks());
        System.out.println("Artworks: " + libraryService.getArtworks());
        System.out.println("Readers: " + libraryService.getReaders());

        csvUtils.saveData(libraryService);
    }
}