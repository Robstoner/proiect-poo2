package org.unibuc.services;

import org.unibuc.entities.Artwork;
import org.unibuc.entities.Author;
import org.unibuc.entities.Book;
import org.unibuc.entities.Reader;

import java.util.UUID;

public interface LibraryServiceInterface {
    UUID addAuthor(Author author);
    void removeAuthor(UUID authorId);
    UUID addBook(Book book);
    void removeBook(UUID bookId);
    UUID addReader(Reader reader);
    void removeReader(UUID readerId);
    UUID addArtwork(Artwork artwork);
    void removeArtwork(UUID artworkId);
    void borrowBook(UUID readerId, UUID bookId);
    void returnBook(UUID readerId, UUID bookId);

}
