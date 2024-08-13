package com.askie01.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class Vet extends Person {
    private final Set<Speciality> specialities = new HashSet<>();
}
