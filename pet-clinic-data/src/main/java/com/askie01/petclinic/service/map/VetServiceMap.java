package com.askie01.petclinic.service.map;

import com.askie01.petclinic.model.Speciality;
import com.askie01.petclinic.model.Vet;
import com.askie01.petclinic.service.SpecialtyService;
import com.askie01.petclinic.service.VetService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;

import java.util.Set;

@Data
@Service
@EqualsAndHashCode(callSuper = true)
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (vetExists(vet)) {
            persistSpecialities(vet);
            return super.save(vet);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    private void persistSpecialities(Vet vet) {
        final Set<Speciality> specialities = vet.getSpecialities();
        if (specialtiesExist(specialities)) {
            specialities.forEach(this::persistSpeciality);
        }
    }

    private void persistSpeciality(Speciality speciality) {
        if (specialityExists(speciality)) {
            saveSpeciality(speciality);
        }
    }

    private void saveSpeciality(Speciality speciality) {
        if (specialityIdExists(speciality)) {
            specialtyService.save(speciality);
        }
    }

    private boolean vetExists(Vet vet) {
        return vet != null;
    }

    private boolean specialtiesExist(Set<Speciality> specialities) {
        return !specialities.isEmpty();
    }

    private boolean specialityExists(Speciality speciality) {
        return speciality != null;
    }

    private boolean specialityIdExists(Speciality speciality) {
        return speciality.getId() != null;
    }
}
