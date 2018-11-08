package eu.seatter.jaspetclinic.services.map;

import eu.seatter.jaspetclinic.model.Speciality;
import eu.seatter.jaspetclinic.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 07/11/2018
 * Time: 15:25
 */
@Disabled
class VetServiceMapTest {


    private SpecialtyServiceMap specialtyServiceMap;
    private VetServiceMap vetServiceMap;

    private final String surgery = "Surgery";
    private Long vetID;

    @BeforeEach
    void setUp() {
        specialtyServiceMap = new SpecialtyServiceMap();
        vetServiceMap = new VetServiceMap(specialtyServiceMap);

        Set<Speciality> specialities = new HashSet<>();

        Speciality speciality = new Speciality();
        speciality.setDescription(surgery);

        Vet vet = new Vet();
        vet.setFirstName("Doug");
        vet.setLastName("Connor");
        vet.setSpecialties(specialities);
        vet.setId(vetID);
        vetServiceMap.save(vet);
        vetID = vet.getId();

    }

    @Test
    void findAll() {
        Set<Vet> vets = vetServiceMap.findAll();
        assertNotNull(vets);
        assertEquals(1,vets.size());
    }

    @Test
    void findById() {
        Vet vet = vetServiceMap.findById(vetID);
        assertNotNull(vet);
        assertEquals(vetID, vet.getId());
    }

    @Test
    void delete() {
        vetServiceMap.delete(vetServiceMap.findById(vetID));
        assertEquals(0,vetServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        vetServiceMap.deleteById(vetID);
        assertEquals(0,vetServiceMap.findAll().size());
    }
}