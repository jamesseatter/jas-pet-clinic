package eu.seatter.jaspetclinic.services;

import eu.seatter.jaspetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
