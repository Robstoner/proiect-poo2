package org.unibuc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.unibuc.entities.enums.Genre;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Author extends Person{
    private List<Genre> genres;
    private List<Book> books;
    private List<Artwork> artworks;

    public Author(UUID id, String name, Date dob, String email, List<Genre> genres, List<Book> books, List<Artwork> artworks) {
        super(id, name, dob, email);
        this.genres = genres;
        this.books = books;
        this.artworks = artworks;
    }

    public Author(UUID id, String name, Date dob, String email, List<Genre> genres) {
        super(id, name, dob, email);
        this.genres = genres;
        this.books = new ArrayList<>();
        this.artworks = new ArrayList<>();
    }

    public Author(UUID id, String name, Date dob, String email) {
        super(id, name, dob, email);
        this.genres = new ArrayList<>();
        this.books = new ArrayList<>();
        this.artworks = new ArrayList<>();
    }

    public String toCSV() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}


