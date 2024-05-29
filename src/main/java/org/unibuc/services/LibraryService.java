package org.unibuc.services;

import org.unibuc.entities.Artwork;
import org.unibuc.entities.Author;
import org.unibuc.entities.Book;
import org.unibuc.entities.Reader;
import org.unibuc.exceptions.BookAlreadyBorrowedException;
import org.unibuc.exceptions.BookNotFoundException;

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
        if (author.getId() == null) {
            author.setId(UUID.randomUUID());
        }
        UUID authorId = author.getId();
        authors.put(authorId, author);
        return authorId;
    }

    @Override
    public void removeAuthor(UUID authorId) {
        authors.remove(authorId);
    }

    @Override
    public UUID addBook(Book book) {
        if (book.getId() == null) {
            book.setId(UUID.randomUUID());
        }
        UUID bookId = book.getId();
        books.put(bookId, book);
        return bookId;
    }

    @Override
    public void removeBook(UUID bookId) {
        books.remove(bookId);
    }

    @Override
    public UUID addReader(Reader reader) {
        if (reader.getId() == null) {
            reader.setId(UUID.randomUUID());
        }
        UUID readerId = reader.getId();
        readers.put(readerId, reader);
        return readerId;
    }

    @Override
    public void removeReader(UUID readerId) {
        readers.remove(readerId);
    }

    @Override
    public UUID addArtwork(Artwork artwork) {
        if (artwork.getId() == null) {
            artwork.setId(UUID.randomUUID());
        }
        UUID artworkId = artwork.getId();
        artworks.put(artworkId, artwork);
        return artworkId;
    }

    @Override
    public void removeArtwork(UUID artworkId) {
        artworks.remove(artworkId);
    }

    @Override
    public void borrowBook(UUID readerId, UUID bookId) throws BookAlreadyBorrowedException, BookNotFoundException {
        Reader reader = readers.get(readerId);
        Book book = books.get(bookId);
        if (reader == null || book == null) {
            throw new BookNotFoundException();
        }
        if (reader.getBorrowedBooks().contains(book)) {
            throw new BookAlreadyBorrowedException();
        }
        if (book.getIsBorrowed()) {
            throw new BookAlreadyBorrowedException();
        }
        reader.getBorrowedBooks().add(book);
        book.setIsBorrowed(true);
    }

    @Override
    public void returnBook(UUID readerId, UUID bookId) throws BookNotFoundException {
        Reader reader = readers.get(readerId);
        Book book = books.get(bookId);
        if (reader == null || book == null) {
            throw new BookNotFoundException();
        }
        if (!reader.getBorrowedBooks().contains(book)) {
            throw new BookNotFoundException();
        }
        reader.getBorrowedBooks().remove(book);
        book.setIsBorrowed(false);
    }

    @Override
    public HashMap<UUID, Author> getAuthors() {
        return authors;
    }

    @Override
    public HashMap<UUID, Book> getBooks() {
        return books;
    }

    @Override
    public HashMap<UUID, Reader> getReaders() {
        return readers;
    }

    @Override
    public HashMap<UUID, Artwork> getArtworks() {
        return artworks;
    }
}
