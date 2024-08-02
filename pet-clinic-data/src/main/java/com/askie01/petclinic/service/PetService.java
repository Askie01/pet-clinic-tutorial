package com.askie01.petclinic.service;

import com.askie01.petclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public interface PetService extends CrudService<Pet, Long> {
}
