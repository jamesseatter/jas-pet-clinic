package eu.seatter.jaspetclinic.services.map;

import eu.seatter.jaspetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 07/11/2018
 * Time: 11:46
 */
class PetTypeServiceMapTest {
    private PetTypeServiceMap petTypeServiceMap;

    private final String frog = "Frog";
    private Long petTypeId;

    @BeforeEach
    void setUp() {
        petTypeServiceMap = new PetTypeServiceMap();

        PetType petType = petTypeServiceMap.save(PetType.builder().name(frog).build());
        petTypeId = petType.getId();
    }

    @Test
    void findAll() {
        Set<PetType> petTypes = petTypeServiceMap.findAll();

        assertEquals(1,petTypes.size());
    }

    @Test
    void findById() {
        PetType petType = petTypeServiceMap.findById(petTypeId);

        assertNotNull(petType);
        assertEquals(petTypeId, petType.getId());
    }

    @Test
    void save() {
        PetType petType = petTypeServiceMap.save(PetType.builder().name("snake").build());
        assertNotNull(petType);
        assertEquals(petType.getId(), petTypeServiceMap.findById(petType.getId()).getId());
    }

    @Test
    void delete() {
        petTypeServiceMap.delete(petTypeServiceMap.findById(petTypeId));
        assertEquals(0, petTypeServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        petTypeServiceMap.deleteById(petTypeId);
        assertNull(petTypeServiceMap.findById(petTypeId));
        assertEquals(0,petTypeServiceMap.findAll().size());
    }
}