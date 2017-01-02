package pl.primesystems.clientsystem.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, columnDefinition = "VARCHAR(30)")
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "VARCHAR(30)")
    private String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "CHAR(40)")
    private String password;

}
