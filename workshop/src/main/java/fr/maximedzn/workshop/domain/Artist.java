package fr.maximedzn.workshop.domain;

import fr.maximedzn.workshop.enums.ArtistStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Artist extends GenericEntity {
    private String nickName;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date birthDate;
    private String nationality;
    @Enumerated(EnumType.STRING)
    private ArtistStyle artistStyle;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private Set<Album> album;
}
