package entities;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "prisoner")

public class Prisoner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idPrisoner;

    @Column(name = "firstname", nullable = false)
    public String firstName;

    @Column(name = "lastname", nullable = false)
    public String lastName;

    @Column(name = "securitylevel", nullable = false)
    public int securityLevel;

    @Column(name = "entrydate", nullable = false)
    public String entryDate;

    @Column(name = "releasedate", nullable = false)
    public String releaseDate;

    @ManyToOne(targetEntity = Prison.class)
    @JoinColumn(name = "idprison")
    public int idPrison;

    @Column(name = "reason", nullable = false)
    public String reason;

}
