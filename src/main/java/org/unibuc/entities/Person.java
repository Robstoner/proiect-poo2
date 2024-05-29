package org.unibuc.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public abstract class Person extends LibraryEntity{
    private String name;
    private Date dob;
    private String email;

    public Person(UUID id, String name, Date dob, String email) {
        super(id);
        this.name = name;
        this.dob = dob;
        this.email = email;
    }
}
