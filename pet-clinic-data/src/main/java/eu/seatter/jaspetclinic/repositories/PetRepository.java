package eu.seatter.jaspetclinic.repositories;

import eu.seatter.jaspetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 31/10/2018
 * Time: 14:26
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
