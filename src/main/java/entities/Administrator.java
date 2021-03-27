package entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@NamedQueries({
        @NamedQuery(name = "returnAdministratorById", query = "select a from Administrator a" +
                " where idAdministrator = :idAdministrator")
})

@Entity
@Table(name = "administrator")

public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdministrator;

    @Column(name = "cnp", nullable = false, unique = true)
    private String CNP;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL,fetch = FetchType.EAGER) //.ALL sterge tot ce este legat de Admin, .PERSIST nu sterge
    private List<Prison> prisonsList;


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

