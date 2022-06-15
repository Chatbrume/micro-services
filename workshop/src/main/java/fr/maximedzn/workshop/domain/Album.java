package fr.maximedzn.workshop.domain;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Album extends GenericEntity{

    private String name;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Artist artist;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date releasedAt;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private Set<Song> songs;



}
