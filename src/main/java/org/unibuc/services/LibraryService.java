package org.unibuc.services;

import org.unibuc.entities.Artwork;
import org.unibuc.entities.Author;
import org.unibuc.entities.Book;
import org.unibuc.entities.Reader;

import java.util.HashMap;
import java.util.UUID;

public class LibraryService implements LibraryServiceInterface {
    private static LibraryService instance;

    private HashMap<UUID, Author> authors;
    private HashMap<UUID, Book> books;
    private HashMap<UUID, Reader> readers;
    private HashMap<UUID, Artwork> artworks;

    private LibraryService() {
        authors = new HashMap<>();
        books = new HashMap<>();
        readers = new HashMap<>();
        artworks = new HashMap<>();
    }

    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    @Override
    public UUID addAuthor(Author author) {
        UUID authorId = UUID.randomUUID();
        author.setId(authorId);
        authors.put(authorId, author);
        return authorId;
    }

    @Override
    public void removeAuthor(UUID authorId) {
        authors.remove(authorId);
    }

    @Override
    public UUID addBook(Book book) {
        UUID bookId = UUID.randomUUID();
        book.setId(bookId);
        books.put(bookId, book);
        return bookId;
    }

    @Override
    public void removeBook(UUID bookId) {
        books.remove(bookId);
    }

    @Override
    public UUID addReader(Reader reader) {
        UUID readerId = UUID.randomUUID();
        reader.setId(readerId);
        readers.put(readerId, reader);
        return readerId;
    }

    @Override
    public void removeReader(UUID readerId) {
        readers.remove(readerId);
    }

    @Override
    public UUID addArtwork(Artwork artwork) {
        UUID artworkId = UUID.randomUUID();
        artwork.setId(artworkId);
        artworks.put(artworkId, artwork);
        return artworkId;
    }

    @Override
    public void removeArtwork(UUID artworkId) {
        artworks.remove(artworkId);
    }

    @Override
    public void borrowBook(UUID readerId, UUID bookId) {
        Reader reader = readers.get(readerId);
        Book book = books.get(bookId);
        reader.getBorrowedBooks().add(book);
        book.setIsBorrowed(true);
    }

    @Override
    public void returnBook(UUID readerId, UUID bookId) {
        Reader reader = readers.get(readerId);
        Book book = books.get(bookId);
        reader.getBorrowedBooks().remove(book);
        book.setIsBorrowed(false);
    }
}
