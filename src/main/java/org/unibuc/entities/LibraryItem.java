package org.unibuc.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.unibuc.entities.enums.Genre;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public abstract class LibraryItem extends LibraryEntity{
    private Author author;
    private Date releaseDate;
    private String name;
    private String description;
}
