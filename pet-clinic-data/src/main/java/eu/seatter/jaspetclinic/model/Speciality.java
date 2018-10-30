package eu.seatter.jaspetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jas on 22/10/2018
 */
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity {

    @Column(name="description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
