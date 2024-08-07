package com.askie01.petclinic.bootstrap;

import com.askie01.petclinic.model.Owner;
import com.askie01.petclinic.model.Vet;
import com.askie01.petclinic.service.OwnerService;
import com.askie01.petclinic.service.VetService;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Data
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

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
        michaelWeston.setFirstName("Michael");
        michaelWeston.setLastName("Weston");

        ownerService.save(michaelWeston);

        final Owner fionaGlenanne = new Owner();
        fionaGlenanne.setFirstName("Fiona");
        fionaGlenanne.setLastName("Glenanne");

        ownerService.save(fionaGlenanne);
        System.out.println("Loaded owners...");

        final Vet samAxe = new Vet();
        samAxe.setFirstName("Sam");
        samAxe.setLastName("Axe");

        vetService.save(samAxe);

        final Vet jessiePorter = new Vet();
        jessiePorter.setFirstName("Jessie");
        jessiePorter.setLastName("Porter");

        vetService.save(jessiePorter);
        System.out.println("Loaded vets...");
    }
}
