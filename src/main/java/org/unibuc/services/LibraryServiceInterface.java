package org.unibuc.services;

import org.unibuc.entities.Artwork;
import org.unibuc.entities.Author;
import org.unibuc.entities.Book;
import org.unibuc.entities.Reader;
import org.unibuc.exceptions.BookAlreadyBorrowedException;
import org.unibuc.exceptions.BookNotFoundException;

import java.util.HashMap;
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
    void borrowBook(UUID readerId, UUID bookId) throws BookAlreadyBorrowedException, BookNotFoundException;
    void returnBook(UUID readerId, UUID bookId) throws BookNotFoundException;
    HashMap<UUID, Author> getAuthors();
    HashMap<UUID, Book> getBooks();
    HashMap<UUID, Reader> getReaders();
    HashMap<UUID, Artwork> getArtworks();
}
