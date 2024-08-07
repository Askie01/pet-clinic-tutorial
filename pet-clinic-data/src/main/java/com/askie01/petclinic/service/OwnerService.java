package com.askie01.petclinic.service;

import com.askie01.petclinic.model.Owner;
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
