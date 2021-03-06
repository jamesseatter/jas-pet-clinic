package eu.seatter.jaspetclinic.services.map;

import eu.seatter.jaspetclinic.model.PetType;
import eu.seatter.jaspetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by jas on 22/10/2018
 */
@Service
@Profile({"default","map"})
public class PetTypeServiceMap extends AbstractServiceMap<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
