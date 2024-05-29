package org.unibuc.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.unibuc.entities.enums.Genre;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public abstract class LibraryItem extends LibraryEntity{
    private Author author;
    private String authorName;
    private Date releaseDate;
    private String name;
    private String description;

    public LibraryItem(UUID id, String authorName, Date releaseDate, String name, String description) {
        super(id);
        this.authorName = authorName;
        this.releaseDate = releaseDate;
        this.name = name;
        this.description = description;
    }
}
