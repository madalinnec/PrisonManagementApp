package entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;
import repository.TableManagement;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@NamedQueries({
        @NamedQuery(name = "returnPrisonById", query = "select a from Prison a" +
                " where idPrison = :idPrison")
})

@Entity
@Table (name = "prison")

public class Prison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrison;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column (name = "securitylevel", nullable = false)
    private int securityLevel;

    @Column (name = "capacity", nullable = false)
    private int capacity;

    @ManyToOne(targetEntity = Administrator.class)
    @JoinColumn(name = "idadministrator")
    @ToString.Exclude //sa nu repete toString la infinit
    private Administrator administrator;

    @OneToMany(mappedBy = "prison", cascade = CascadeType.ALL,fetch = FetchType.EAGER) //.ALL sterge tot ce este legat de Admin, .PERSIST nu sterge
    private List<Prisoner> prisonersList;

    public Prison insertNewPrisonDetails(){
        Prison prison = new Prison();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert prison name: ");
        String name = scanner.next();
        prison.setName(name);
        System.out.println("Insert prison security level (1/2/3): ");
        int securityLevel = scanner.nextInt();
        prison.setSecurityLevel(securityLevel);
        System.out.println("Insert prison capacity: ");
        int capacity = scanner.nextInt();
        prison.setCapacity(capacity);
        System.out.println("Insert prison's administrator ID: ");
        int idAdministrator = scanner.nextInt();
        prison.administrator = new TableManagement().returnAdministratorById(idAdministrator);
        return prison;
    }


}
