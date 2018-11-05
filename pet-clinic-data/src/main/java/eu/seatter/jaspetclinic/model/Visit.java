package eu.seatter.jaspetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by jas on 22/10/2018
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;
}
