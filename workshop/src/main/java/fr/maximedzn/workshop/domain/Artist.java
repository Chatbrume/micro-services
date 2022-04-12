package fr.maximedzn.workshop.domain;

import fr.maximedzn.workshop.enums.ArtistStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickName;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date birthDate;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date createdAt;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date modifiedAt;
    private ArtistStyle artistStyle;

    @PrePersist
    public void prePersist(){
        Date d = new Date();
        this.createdAt = d;
        this.modifiedAt = d;
    }

    @PreUpdate
    public void preUpdate(){
        this.modifiedAt = new Date();
    }

}
