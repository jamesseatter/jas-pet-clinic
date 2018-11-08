package eu.seatter.jaspetclinic.services.springdatajpa;

import eu.seatter.jaspetclinic.model.Owner;
import eu.seatter.jaspetclinic.repositories.OwnerRepository;
import eu.seatter.jaspetclinic.repositories.PetRepository;
import eu.seatter.jaspetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 08/11/2018
 * Time: 10:57
 */
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private static final String LAST_NAME = "smith";

    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerSDJpaService service;

    private Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        // Mock a response
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        // Test the service
        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        // Mock a response
        Set<Owner> returnedOwnersSet = new HashSet<>();
        returnedOwnersSet.add(Owner.builder().id(1L).build());
        returnedOwnersSet.add(Owner.builder().id(2L).build());

        // when the method findAll is executed on the Repository return the HashSet
        when(ownerRepository.findAll()).thenReturn(returnedOwnersSet);

        // Test the service
        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        assertEquals(0,service.findAll().size());
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        assertEquals(0, service.findAll().size());
        verify(ownerRepository).deleteById(anyLong());
    }
}