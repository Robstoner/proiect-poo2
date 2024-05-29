package org.unibuc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.unibuc.entities.enums.Style;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Artwork extends LibraryItem {
    private Style style;
    private int width;
    private int height;

    public Artwork(UUID id, String authorName, Date releaseDate, String name, String description, Style style, int width, int height) {
        super(id, authorName, releaseDate, name, description);
        this.style = style;
        this.width = width;
        this.height = height;
    }

    public String toCSV() {
        return this.getClass().getSimpleName() + "," + this.getId() + "," + this.getName() + "," + this.getReleaseDate().toInstant() + "," + this.getAuthorName() + "," + this.getStyle() + "," + this.getWidth() + "," + this.getHeight() + "," + this.getDescription();
    }

    public static LibraryEntity fromCSV(String[] values) {
        Artwork artwork = new Artwork();
        artwork.setId(UUID.fromString(values[0]));
        artwork.setName(values[1]);
        artwork.setReleaseDate(Date.from(Instant.parse(values[2])));
        artwork.setAuthorName(values[3]);
        artwork.setStyle(Style.valueOf(values[4]));
        artwork.setWidth(Integer.parseInt(values[5]));
        artwork.setHeight(Integer.parseInt(values[6]));
        artwork.setDescription(values[7]);
        return artwork;
    }
}
