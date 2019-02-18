package eu.seatter.jaspetclinic.services.map;

import eu.seatter.jaspetclinic.model.Owner;
import eu.seatter.jaspetclinic.model.Pet;
import eu.seatter.jaspetclinic.model.PetType;
import eu.seatter.jaspetclinic.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 07/11/2018
 * Time: 15:04
 */
class VisitServiceMapTest {

    private VisitServiceMap visitServiceMap;
    private PetTypeServiceMap petTypeServiceMap;
    private PetServiceMap petServiceMap;
    private OwnerServiceMap ownerServiceMap;

    private Long petTypeId;
    private Long petId;
    private Long visitID;


    @BeforeEach
    private void setUp() {
        petServiceMap = new PetServiceMap();
        petTypeServiceMap = new PetTypeServiceMap();
        ownerServiceMap = new OwnerServiceMap(petTypeServiceMap,petServiceMap);

        // Create test pet type
        PetType petTypeCat = new PetType();
        petTypeCat.setName("Cat");
        petTypeCat.setId(petTypeId);
        petTypeServiceMap.save(petTypeCat);
        petTypeId = petTypeCat.getId();

        // Create test owner
        Owner owner = new Owner();
        owner.setFirstName("Jim");
        owner.setLastName("Golsot");
        ownerServiceMap.save(owner);

        // Create test pet
        Pet petCat = new Pet();
        petCat.setPetType(petTypeCat);
        petCat.setBirthDate(LocalDate.now().minusYears(2));
        petCat.setName("Kitty");
        petCat.setId(petId);
        petCat.setOwner(owner);
        petServiceMap.save(petCat);
        petId = petCat.getId();

        visitServiceMap = new VisitServiceMap();
        Visit visit = new Visit();
        visit.setPet(petCat);
        visit.setDescription("TEST VISIT");
        visit.setDate(LocalDate.now().plusDays(2));

        visitServiceMap.save(visit);
        visitID = visit.getId();
    }

    @Test
    void findAll() {
        Set<Visit> visits = visitServiceMap.findAll();

        assertEquals(1, visitServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Visit visit = visitServiceMap.findById(visitID);
        assertNotNull(visit);
        assertEquals(visitID, visit.getId());
    }


    @Test
    void delete() {
        visitServiceMap.delete(visitServiceMap.findById(visitID));

        assertEquals(0,visitServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        visitServiceMap.deleteById(visitID);

        assertEquals(0,visitServiceMap.findAll().size());
    }
}