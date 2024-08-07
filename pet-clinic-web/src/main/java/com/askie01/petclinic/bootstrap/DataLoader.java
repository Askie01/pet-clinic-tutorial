package com.askie01.petclinic.bootstrap;

import com.askie01.petclinic.model.Owner;
import com.askie01.petclinic.model.Vet;
import com.askie01.petclinic.service.OwnerService;
import com.askie01.petclinic.service.VetService;
import com.askie01.petclinic.service.map.OwnerServiceMap;
import com.askie01.petclinic.service.map.VetServiceMap;
import lombok.SneakyThrows;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    @SneakyThrows
    public void run(String... args) {
        final Owner michaelWeston = new Owner();
        michaelWeston.setId(1L);
        michaelWeston.setFirstName("Michael");
        michaelWeston.setLastName("Weston");

        ownerService.save(michaelWeston);

        final Owner fionaGlenanne = new Owner();
        fionaGlenanne.setId(2L);
        fionaGlenanne.setFirstName("Fiona");
        fionaGlenanne.setLastName("Glenanne");

        ownerService.save(fionaGlenanne);
        System.out.println("Loaded owners...");

        final Vet samAxe = new Vet();
        samAxe.setId(1L);
        samAxe.setFirstName("Sam");
        samAxe.setLastName("Axe");

        vetService.save(samAxe);

        final Vet jessiePorter = new Vet();
        jessiePorter.setId(2L);
        jessiePorter.setFirstName("Jessie");
        jessiePorter.setLastName("Porter");

        vetService.save(jessiePorter);
        System.out.println("Loaded vets...");
    }
}
