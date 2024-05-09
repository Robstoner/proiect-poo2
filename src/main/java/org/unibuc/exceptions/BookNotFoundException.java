package org.unibuc.exceptions;

public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super("Book not found");
    }

    public BookNotFoundException(String bookName) {
        super("Book " + bookName + " not found");
    }
}
