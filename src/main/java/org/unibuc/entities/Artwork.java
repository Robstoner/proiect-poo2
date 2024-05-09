package org.unibuc.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.unibuc.entities.enums.Style;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Artwork extends LibraryItem {
    private Style style;
    private int width;
    private int height;

    public String toCSV() {
        return this.getClass().getSimpleName() + "," + this.getId() + "," + this.getName() + "," + this.getReleaseDate() + "," + this.getAuthor() + "," + this.getStyle() + "," + this.getWidth() + "," + this.getHeight() + "," + this.getDescription();
    }
}
