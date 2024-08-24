package com.askie01.petclinic.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
}
