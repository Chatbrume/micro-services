package fr.maximedzn.workshop.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Song extends GenericEntity{

    private String name;
    private Integer duration;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Album album;

}
