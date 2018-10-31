package eu.seatter.jaspetclinic.repositories;

import eu.seatter.jaspetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 31/10/2018
 * Time: 14:31
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
