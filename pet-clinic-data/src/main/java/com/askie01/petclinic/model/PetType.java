package com.askie01.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PetType extends BaseEntity {
    private String name;
}
