package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.vet.VetRepository;

@SpringBootTest
class ProductionConfigurationTests {

    @Autowired
    private VetRepository vets;

    @Test
    void findAll() throws Exception {
        vets.findAll();
        vets.findAll(); // served from cache
    }
}
