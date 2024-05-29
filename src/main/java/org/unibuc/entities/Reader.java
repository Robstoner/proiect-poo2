package org.unibuc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Reader extends Person {
    private List<Book> borrowedBooks;

    public Reader(UUID id, String name, Date dob, String email, List<Book> borrowedBooks) {
        super(id, name, dob, email);
        this.borrowedBooks = borrowedBooks;
    }

    public Reader(UUID id, String name, Date dob, String email) {
        super(id, name, dob, email);
        this.borrowedBooks = new ArrayList<>();
    }

    public String toCSV() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
