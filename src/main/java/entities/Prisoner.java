package entities;

import lombok.*;
import repository.TableManagement;

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
    private long idPrisoner;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "securitylevel", nullable = false)
    private int securityLevel;

    @Column(name = "entrydate", nullable = false)
    private String entryDate;

    @Column(name = "releasedate", nullable = false)
    private String releaseDate;

    @ManyToOne(targetEntity = Prison.class)
    @JoinColumn(name = "idPrison")
    @ToString.Exclude
    private Prison prison;

    @Column(name = "reason", nullable = false)
    private String reason;

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
        prisoner.prison = new TableManagement().returnPrisonById(idPrison);
        System.out.println("Insert reason for incarceration: ");
        String reason = scanner.next();
        prisoner.setReason(reason);
        return prisoner;
    }
}
