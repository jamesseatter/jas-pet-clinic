package eu.seatter.jaspetclinic.services.map;


import eu.seatter.jaspetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 06/11/2018
 * Time: 15:11
 */
class OwnerServiceMapTest {
    private OwnerServiceMap ownerServiceMap;

    private final String lastName = "Seatter";
    private Long ownerId;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        Owner owner = Owner.builder().lastName(lastName).build();

        ownerServiceMap.save(owner);
        ownerId = owner.getId();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {

        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);

        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner2 = ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner2);

        assertEquals(ownerId, owner2.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner2 = ownerServiceMap.findByLastName("foo");

        assertNull(owner2);

    }
}