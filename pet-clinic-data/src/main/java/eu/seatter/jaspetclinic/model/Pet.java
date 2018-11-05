package eu.seatter.jaspetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jas on 22/10/2018
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDay;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="pet")
    private Set<Visit> visits = new HashSet<>();

}
