package entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table (name = "prison")

public class Prison {

    @ManyToMany(mappedBy = "prisons")
    public Set<Administrator> administrators = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idPrison;

    @Column(name = "name", unique = true, nullable = false)
    public String name;

    @Column (name = "securitylevel", nullable = false)
    public int securityLevel;

    @Column (name = "capacity", nullable = false)
    public int capacity;

//    @Column (name = "adminusername", nullable = false)
    public String adminUsername;

//    public Prison createNewPrison(){
//
//    }

}
