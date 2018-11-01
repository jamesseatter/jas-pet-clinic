package eu.seatter.jaspetclinic.services.map;

import eu.seatter.jaspetclinic.model.Speciality;
import eu.seatter.jaspetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by jas on 24/10/2018
 */
@Service
@Profile({"default","map"})
public class SpecialtyServiceMap extends AbstractServiceMap<Speciality, Long> implements SpecialtyService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
