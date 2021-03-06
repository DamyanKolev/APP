package net.javaguides.springboot.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    @NotEmpty(message = "error.firstName.empty")
    @Length(max = 50, message = "error.firstName.length")
    private String firstName;

    @NotEmpty(message = "error.lastName.empty")
    @Length(max = 50, message = "error.lastName.length")
    private String lastName;

    @Email(message = "error.email.email")
    @NotEmpty(message = "error.email.empty")
    @Length(max = 80, message = "error.email.length")
    private String email;

    @Length(max = 25, message = "error.username.length")
    @NotEmpty(message = "error.username.empty")
    private String username;

    @Length(max = 20, message = "error.password.length")
    @NotEmpty(message = "error.password.empty")
    private String password;

    @Length(max = 50, message = "error.companyName.length")
    @NotEmpty(message = "error.companyName.empty")
    private String companyName;

    @NotEmpty(message = "error.address.empty")
    @Length(max = 150, message = "error.address.length")
    private String address;

    @Length(max = 15, message = "error.city.length")
    @NotEmpty(message = "error.city.empty")
    private String city;

    @Length(max = 15, message = "error.region.length")
    @NotEmpty(message = "error.region.empty")
    private String region;

    @Length(max = 8, message = "error.postalCode.length")
    @NotEmpty(message = "error.postalCode.empty")
    private String postalCode;

    @Length(max = 15, message = "error.country.length")
    @NotEmpty(message = "error.country.empty")
    private String country;

    @Length(max = 15, message = "error.phone.length")
    @NotEmpty(message = "error.phone.empty") 
    private Integer phone;
}
