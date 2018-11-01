package eu.seatter.jaspetclinic.services.map;

import eu.seatter.jaspetclinic.model.Visit;
import eu.seatter.jaspetclinic.services.VisitService;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 01/11/2018
 * Time: 11:19
 */
public class VisitServiceMap  extends AbstractServiceMap<Visit, Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null
                || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }

        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
