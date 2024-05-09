package org.unibuc.exceptions;

public class BookAlreadyBorrowedException extends Exception {
    public BookAlreadyBorrowedException() {
        super("Book already borrowed");
    }

    public BookAlreadyBorrowedException(String bookName) {
        super("Book " + bookName + " already borrowed");
    }
}
