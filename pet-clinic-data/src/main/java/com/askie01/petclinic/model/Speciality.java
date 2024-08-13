package com.askie01.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Speciality extends BaseEntity {
    private String description;
}
