package entities;

import lombok.*;

import javax.persistence.*;
import java.util.Scanner;


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

    public Prisoner insertNewPrisonerDetails() {
        Prisoner prisoner = new Prisoner();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert prisoner's first name: ");
        String firstName = scanner.next();
        prisoner.setFirstName(firstName);
        System.out.println("Insert prisoner's last name: ");
        String lastName = scanner.next();
        prisoner.setLastName(lastName);
        System.out.println("Insert prisoner's security level: ");
        int securityLevel = scanner.nextInt();
        prisoner.setSecurityLevel(securityLevel);
        System.out.println("Insert prisoner's date of incarceration: ");
        String incarcerationDate = scanner.next();
        prisoner.setEntryDate(incarcerationDate);
        System.out.println("Insert prisoner's release date: ");
        String releaseDate = scanner.next();
        prisoner.setReleaseDate(releaseDate);
        System.out.println("Insert the ID for the prison the prisoner should be assigned to: ");
        int idPrison = scanner.nextInt();
        prisoner.setIdPrison(idPrison);
        System.out.println("Insert reason for incarceration: ");
        String reason = scanner.next();
        prisoner.setReason(reason);
        return prisoner;
    }
}
