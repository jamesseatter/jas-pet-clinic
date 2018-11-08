package eu.seatter.jaspetclinic.services.map;

import eu.seatter.jaspetclinic.model.Speciality;
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
 * Time: 23:41
 */
@Disabled
class SpecialtyServiceMapTest {

    private SpecialtyServiceMap specialtyServiceMap;

    private final String surgery = "Surgery";
    private Long specialtyId;

    @BeforeEach
    void setUp() {
        specialtyServiceMap = new SpecialtyServiceMap();

        Set<Speciality> specialities = new HashSet<>();

        Speciality speciality = new Speciality();
        speciality.setDescription(surgery);
        specialtyServiceMap.save(speciality);
        specialtyId = speciality.getId();
    }


    @Test
    void findAll() {
        Set<Speciality> specialities = specialtyServiceMap.findAll();

        assertNotNull(specialities);
        assertEquals(1,specialities.size());
    }

    @Test
    void findById() {
        Speciality speciality = specialtyServiceMap.findById(specialtyId);
        assertNotNull(speciality);
        assertEquals(specialtyId, speciality.getId());
    }

    @Test
    void delete() {
        specialtyServiceMap.delete(specialtyServiceMap.findById(specialtyId));
        assertEquals(0, specialtyServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        specialtyServiceMap.deleteById(specialtyId);
        assertEquals(0, specialtyServiceMap.findAll().size());
    }
}