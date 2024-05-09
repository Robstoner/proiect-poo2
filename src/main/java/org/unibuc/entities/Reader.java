package org.unibuc.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Reader extends Person {
    private List<Book> borrowedBooks;

    public String toCSV() {
        return this.getClass().getSimpleName() + "," + this.getId() + "," + this.getName() + "," + this.getDob() + "," + this.getEmail() + "," + this.getBorrowedBooks();
    }
}
