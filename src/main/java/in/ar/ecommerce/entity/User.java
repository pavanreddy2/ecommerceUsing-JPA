package in.ar.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(
        name ="user_email",
        columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable (name = "users_roles",
            joinColumns = @JoinColumn (
                    name = "user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn (
                    name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
