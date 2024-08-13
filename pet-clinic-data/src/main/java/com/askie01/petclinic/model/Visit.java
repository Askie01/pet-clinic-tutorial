package com.askie01.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class Visit extends BaseEntity {
    private LocalDate date;
    private String description;
    private Pet pet;
}
