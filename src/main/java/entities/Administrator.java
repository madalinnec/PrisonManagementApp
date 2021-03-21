package entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table (name = "administrator")

public class Administrator {

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "prisons_administrators",
            joinColumns = {@JoinColumn(name = "idAdministrator")},
            inverseJoinColumns = {@JoinColumn(name = "idPrison")}
    )
    Set<Prison> prisons = new HashSet<>();

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int idAdministrator;

    @Column (name = "cnp", nullable = false, unique = true)
    public String CNP;

    @Column (name = "firstname", nullable = false)
    public String firstName;

    @Column (name = "lastname", nullable = false)
    public String lastName;

    @Column (name = "adminusername", nullable = false, unique = true)
    public String adminUsername;

    @Column (name = "password", nullable = false)
    public String password;

    @Column (name = "email", nullable = false, unique = true)
    public String email;

    public Administrator createNewAdministrator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert CNP: ");
        String cnp = scanner.next();
        System.out.println("Insert first name: ");
        String firstName = scanner.next();
        System.out.println("Insert last name: ");
        String lastName = scanner.next();
        System.out.println("Insert username: ");
        String username = scanner.next();
        System.out.println("Insert password: ");
        String password = scanner.next();
        System.out.println("Insert email: ");
        String email = scanner.next();
        Administrator administrator = new Administrator();
        administrator.setCNP(cnp);
        administrator.setFirstName(firstName);
        administrator.setLastName(lastName);
        administrator.setAdminUsername(username);
        administrator.setPassword(password);
        administrator.setEmail(email);
        return administrator;
    }

}

