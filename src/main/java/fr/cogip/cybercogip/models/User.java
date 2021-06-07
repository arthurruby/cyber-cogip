package fr.cogip.cybercogip.models;

import fr.cogip.cybercogip.models.enums.Role;
import fr.cogip.cybercogip.security.AttributeEncryptor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 55, message = "Username must be between 3 and 55 letters long")
    @Column(nullable = false, unique = true)
    @Convert(converter = AttributeEncryptor.class)
    private String username;

    @NotBlank
    @Size(min = 5, max = 55)
    @Email
    @Column(nullable = false, unique = true)
    @Convert(converter = AttributeEncryptor.class)
    private String email;

    @NotBlank
    // BCrypt hashes are 60 chars long
    @Size(min = 8, max = 60)
    @Column(nullable = false)
    private String password;

    @Size(max = 55)
    @Column(name = "first_name", nullable = false)
    @Convert(converter = AttributeEncryptor.class)
    private String firstName;

    @Size(max = 55)
    @Column(name = "last_name", nullable = false)
    @Convert(converter = AttributeEncryptor.class)
    private String lastName;

    @Enumerated
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private Boolean isActive = true;

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
        this.username = username.toLowerCase(Locale.ROOT);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase(Locale.ROOT);
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(
                BCryptPasswordEncoder.BCryptVersion.$2A, 31);
        this.password = passwordEncoder.encode(password);
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

    public Boolean getActive() {
        return this.isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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