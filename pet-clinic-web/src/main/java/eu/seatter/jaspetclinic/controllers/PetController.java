package eu.seatter.jaspetclinic.controllers;

import eu.seatter.jaspetclinic.model.Owner;
import eu.seatter.jaspetclinic.model.PetType;
import eu.seatter.jaspetclinic.services.OwnerService;
import eu.seatter.jaspetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 07/03/2019
 * Time: 10:06
 */
@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORMN = "pets/greateOrUpdatePetForm";
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(OwnerService ownerService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBuilder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
