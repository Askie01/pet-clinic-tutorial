package com.askie01.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
}
