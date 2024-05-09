package org.unibuc.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.unibuc.entities.enums.Genre;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Author extends Person{
    private List<Genre> genres;
    private List<Book> books;
    private List<Artwork> artworks;

    public String toCSV() {
        return this.getClass().getSimpleName() + "," + this.getId() + "," + this.getName() + "," + this.getDob() + "," + this.getEmail() + "," + this.getGenres() + "," + this.getBooks() + "," + this.getArtworks();
    }
}


