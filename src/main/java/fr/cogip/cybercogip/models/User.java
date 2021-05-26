package fr.cogip.cybercogip.models;

import fr.cogip.cybercogip.models.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 25, message = "Username must be between 3 and 25 letters long")
    @Column(length = 25, nullable = false, unique = true)
    private String username;

    @NotBlank
    @Size(min = 5, max = 50)
    @Email
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NotBlank
    // BCrypt hashes are 60 chars long
    @Size(min = 60, max = 60)
    @Column(nullable = false, length = 60)
    private String password;

    @Size(max = 50)
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Enumerated
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {
        this.orders = new ArrayList<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String fullName) {
        this.firstName = fullName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.username);
        sb.append(" (").append(this.email).append(')');
        return sb.toString();
    }
}