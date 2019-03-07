package eu.seatter.jaspetclinic.controllers;

import eu.seatter.jaspetclinic.model.Owner;
import eu.seatter.jaspetclinic.model.PetType;
import eu.seatter.jaspetclinic.services.OwnerService;
import eu.seatter.jaspetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 07/03/2019
 * Time: 10:18
 */
@ExtendWith(MockitoExtension.class)
class PetControllerTest {
    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    PetController petController;

    MockMvc mockMvc;
    Owner owner;
    Set<PetType> petTypes;

    @BeforeEach
}