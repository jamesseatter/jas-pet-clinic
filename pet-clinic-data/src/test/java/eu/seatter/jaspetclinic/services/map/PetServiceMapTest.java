package eu.seatter.jaspetclinic.services.map;

import eu.seatter.jaspetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 06/11/2018
 * Time: 17:47
 */
@Disabled
class PetServiceMapTest {

    private PetServiceMap petServiceMap;

    private final String sam = "Sam";
    private Long PetId;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();

        Pet pet = petServiceMap.save(Pet.builder().name(sam).build());
        PetId = pet.getId();
    }

    @Test
    void save() {
        Pet pet = petServiceMap.save(Pet.builder().name("foo").build());
        assertNotNull(pet);
        assertEquals(pet.getId(), petServiceMap.findById(pet.getId()).getId());
    }

    @Test
    void findAll() {
        Set<Pet> pets = petServiceMap.findAll();

        assertEquals(1, pets.size());
    }

    @Test
    void findById() {
        Pet pet = petServiceMap.findById(PetId);
        assertEquals(PetId, pet.getId());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(PetId));
        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(PetId);
        assertNull(petServiceMap.findById(PetId));
        assertEquals(0, petServiceMap.findAll().size());
    }
}