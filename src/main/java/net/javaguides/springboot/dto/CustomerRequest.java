package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String companyName;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private Integer phone;
}
