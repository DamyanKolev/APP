package net.javaguides.springboot.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8715130083333507048L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    @NotEmpty(message = "error.name.empty")
    @Length(max = 50, message = "error.name.length")
    private String lastName;

    @Email(message = "error.email.email")
    @NotEmpty(message = "error.email.empty")
    @Length(max = 80, message = "error.email.length")
    private String email;

    private String username;

    private String password;

    private String companyName;

    // @NotEmpty(message = "error.address.empty")
    @Length(max = 150, message = "error.address.length")
    private String address;

    private String city;

    private String region;

    private String postalCode;

    private String country;

    private Integer phone;

    private Instant created;

    private Role role;

    public User(String firstName, String lastName, String email, String username, String password, String companyName,
            String address, String city, String region, String postalCode, String country, Integer phone,
            Instant created, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.created = created;
        this.role = role;
    }

}
