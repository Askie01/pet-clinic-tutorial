package com.askie01.petclinic.service.map;

import com.askie01.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
class OwnerServiceMapTest {

    @Spy
    private OwnerMapService ownerServiceMap;

    @BeforeEach
    void setUp() {
        final Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Adam");
        owner.setLastName("Kowalski");
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        final Set<Owner> ownerSet = ownerServiceMap.findAll();
        final Integer expectedSetSize = 1;
        final Integer actualSetSize = ownerSet.size();

        assertEquals(expectedSetSize, actualSetSize);
    }

    @Test
    void findById() {
        final Owner owner = ownerServiceMap.findById(1L);
        assertEquals(1L, owner.getId());
    }

    @Test
    void saveExistingId() {
        final Owner owner = new Owner();
        owner.setId(2L);

        final Owner savedOwner = ownerServiceMap.save(owner);
        final Long expectedId = 2L;
        final Long actualId = savedOwner.getId();

        assertEquals(expectedId, actualId);
    }

    @Test
    void automaticallyAssignId() {
        final Owner owner = new Owner();
        final Owner savedOwner = ownerServiceMap.save(owner);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        final Long id = 1L;
        final Owner owner = ownerServiceMap.findById(id);
        assertNotNull(owner);

        ownerServiceMap.delete(owner);
        final Integer expectedMapSize = 0;
        final Integer actualMapSize = ownerServiceMap.findAll().size();

        assertEquals(expectedMapSize, actualMapSize);
    }

    @Test
    void findByLastName() {
        final Owner owner = ownerServiceMap.findByLastName("Kowalski");

        assertNotNull(owner);

        final Long expectedId = 1L;
        final Long actualId = owner.getId();

        assertEquals(expectedId, actualId);
    }

}