package com.askie01.petclinic.service.map;

import com.askie01.petclinic.model.Owner;
import com.askie01.petclinic.model.Pet;
import com.askie01.petclinic.model.PetType;
import com.askie01.petclinic.service.OwnerService;
import com.askie01.petclinic.service.PetService;
import com.askie01.petclinic.service.PetTypeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
@EqualsAndHashCode(callSuper = true)
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetService petService;
    private PetTypeService petTypeService;

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (ownerExists(owner)) {
            persistPets(owner);
            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    private void persistPets(Owner owner) {
        final Set<Pet> pets = owner.getPets();
        if (petsExist(pets)) {
            pets.forEach(this::persistPet);
        }
    }

    private void persistPet(Pet pet) {
        final PetType petType = pet.getPetType();
        if (petTypeExists(petType)) {
            createPetType(pet);
        } else {
            throw new RuntimeException("Pet Type is required");
        }
        savePet(pet);
    }

    private void createPetType(Pet pet) {
        final PetType petType = pet.getPetType();
        if (!petTypeIdExists(petType)) {
            pet.setPetType(petTypeService.save(pet.getPetType()));
        }
    }

    private void savePet(Pet pet) {
        if (petIdExists(pet)) {
            pet.setId(petService.save(pet).getId());
        }
    }

    private boolean ownerExists(Owner owner) {
        return owner != null;
    }

    private boolean petsExist(Set<Pet> pets) {
        return pets != null;
    }

    private boolean petTypeExists(PetType petType) {
        return petType != null;
    }

    private boolean petTypeIdExists(PetType petType) {
        return petType.getId() != null;
    }

    private boolean petIdExists(Pet pet) {
        return pet.getId() != null;
    }
}
