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
@Table (name = "prison")

public class Prison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idPrison;

    @Column(name = "name", unique = true, nullable = false)
    public String name;

    @Column (name = "securitylevel", nullable = false)
    public int securityLevel;

    @Column (name = "capacity", nullable = false)
    public int capacity;

    @ManyToOne(targetEntity = Administrator.class)
    @JoinColumn(name = "idAdministrator")
    public int idAdministrator;

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
        prison.setIdAdministrator(idAdministrator);
        return prison;
    }
}
