package org.unibuc.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public abstract class LibraryEntity {
    private UUID id;

    public LibraryEntity(UUID id) {
        this.id = id;
    }

    public abstract String toCSV();
}
