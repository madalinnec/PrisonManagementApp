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
@Table(name = "administrator")

public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idAdministrator;

    @Column(name = "cnp", nullable = false, unique = true)
    public String CNP;

    @Column(name = "firstname", nullable = false)
    public String firstName;

    @Column(name = "lastname", nullable = false)
    public String lastName;

    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "email", nullable = false, unique = true)
    public String email;

    public Administrator insertNewAdministratorDetails() {
        Administrator administrator = new Administrator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert CNP: ");
        String cnp = scanner.next();
        administrator.setCNP(cnp);
        System.out.println("Insert first name: ");
        String firstName = scanner.next();
        administrator.setFirstName(firstName);
        System.out.println("Insert last name: ");
        String lastName = scanner.next();
        administrator.setLastName(lastName);
        System.out.println("Insert password: ");
        String password = scanner.next();
        administrator.setPassword(password);
        System.out.println("Insert email: ");
        String email = scanner.next();
        administrator.setEmail(email);
        return administrator;
    }
}

