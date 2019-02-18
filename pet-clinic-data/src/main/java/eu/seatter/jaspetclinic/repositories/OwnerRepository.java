package eu.seatter.jaspetclinic.repositories;

import eu.seatter.jaspetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 31/10/2018
 * Time: 14:25
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findByLastNameLikeIgnoreCase(String lastName);
}
