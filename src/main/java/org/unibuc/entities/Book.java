package org.unibuc.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.unibuc.entities.enums.Genre;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Book extends LibraryItem {
    private List<Genre> genres;
    private int numberOfPages;
    private String isbn;
    private String publisher;
    private Boolean isBorrowed;

    public String toCSV() {
        return this.getClass().getSimpleName() + "," + this.getId() + "," + this.getAuthor() + "," + this.getReleaseDate() + "," + this.getName() + "," + this.getDescription() + "," + this.getGenres() + "," + this.getNumberOfPages() + "," + this.getIsbn() + "," + this.getPublisher() + "," + this.getIsBorrowed();
    }
}
