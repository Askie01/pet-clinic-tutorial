package com.askie01.petclinic.bootstrap;

import com.askie01.petclinic.model.*;
import com.askie01.petclinic.service.OwnerService;
import com.askie01.petclinic.service.PetTypeService;
import com.askie01.petclinic.service.SpecialtyService;
import com.askie01.petclinic.service.VetService;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    @Override
    @SneakyThrows
    public void run(String... args) {
        final int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        final PetType dog = petTypeService.save(new PetType("Dog"));
        final PetType cat = petTypeService.save(new PetType("Cat"));

        final Speciality radiology = specialtyService.save(new Speciality("Radiology"));
        final Speciality surgery = specialtyService.save(new Speciality("Surgery"));
        final Speciality dentistry = specialtyService.save(new Speciality("Dentistry"));

        final Owner michaelWeston = new Owner();
        michaelWeston.setFirstName("Michael");
        michaelWeston.setLastName("Weston");
        michaelWeston.setAddress("123 Main street");
        michaelWeston.setCity("Miami");
        michaelWeston.setTelephone("123456789");

        final Pet michaelsDog = new Pet("Rosco", dog, michaelWeston, LocalDate.now());
        michaelWeston.getPets().add(michaelsDog);
        ownerService.save(michaelWeston);

        final Owner fionaGlenanne = new Owner();
        fionaGlenanne.setFirstName("Fiona");
        fionaGlenanne.setLastName("Glenanne");
        fionaGlenanne.setAddress("124 Second street");
        fionaGlenanne.setCity("Washington");
        fionaGlenanne.setTelephone("987654321");

        final Pet fionasCat = new Pet("Just Cat", cat, fionaGlenanne, LocalDate.now());
        fionaGlenanne.getPets().add(fionasCat);
        ownerService.save(fionaGlenanne);
        System.out.println("Loaded owners...");

        final Vet samAxe = new Vet();
        samAxe.setFirstName("Sam");
        samAxe.setLastName("Axe");
        samAxe.getSpecialities().add(radiology);
        vetService.save(samAxe);

        final Vet jessiePorter = new Vet();
        jessiePorter.setFirstName("Jessie");
        jessiePorter.setLastName("Porter");
        jessiePorter.getSpecialities().add(surgery);
        vetService.save(jessiePorter);

        System.out.println("Loaded vets...");
    }
}
