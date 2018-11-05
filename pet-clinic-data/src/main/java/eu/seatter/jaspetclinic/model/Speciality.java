package eu.seatter.jaspetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jas on 22/10/2018
 */

/**
 * Created by jas on 22/10/2018
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity {

    @Column(name="description")
    private String description;
}
