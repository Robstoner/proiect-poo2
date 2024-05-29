package org.unibuc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.unibuc.entities.enums.Genre;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Book extends LibraryItem {
    private Genre genre;
    private int numberOfPages;
    private String isbn;
    private String publisher;
    private Boolean isBorrowed;

    public Book(UUID id, String authorName, Date releaseDate, String name, String description, Genre genre, int numberOfPages, String isbn, String publisher, Boolean isBorrowed) {
        super(id, authorName, releaseDate, name, description);
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publisher = publisher;
        this.isBorrowed = isBorrowed;
    }

    public String toCSV() {
        return this.getClass().getSimpleName() + "," + this.getId() + "," + this.getAuthorName() + "," + this.getReleaseDate().toInstant() + "," + this.getName() + "," + this.getDescription() + "," + this.getGenre() + "," + this.getNumberOfPages() + "," + this.getIsbn() + "," + this.getPublisher() + "," + this.getIsBorrowed();
    }

    public static LibraryEntity fromCSV(String[] values) {
        Book book = new Book();
        book.setId(UUID.fromString(values[0]));
        book.setAuthorName(values[1]);
        book.setReleaseDate(Date.from(Instant.parse(values[2])));
        book.setName(values[3]);
        book.setDescription(values[4]);
        book.setGenre(Genre.valueOf(values[5]));
        book.setNumberOfPages(Integer.parseInt(values[6]));
        book.setIsbn(values[7]);
        book.setPublisher(values[8]);
        book.setIsBorrowed(Boolean.parseBoolean(values[9]));
        return book;
    }
}
