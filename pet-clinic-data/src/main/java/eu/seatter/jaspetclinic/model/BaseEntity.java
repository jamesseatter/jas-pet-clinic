package eu.seatter.jaspetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private Long id;    //hibernate recommends boxed types instead of base types.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
