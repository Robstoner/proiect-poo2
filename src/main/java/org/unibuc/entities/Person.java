package org.unibuc.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public abstract class Person extends LibraryEntity{
    private String name;
    private Date dob;
    private String email;
}
