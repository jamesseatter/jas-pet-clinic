package eu.seatter.jaspetclinic.services;

import eu.seatter.jaspetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
