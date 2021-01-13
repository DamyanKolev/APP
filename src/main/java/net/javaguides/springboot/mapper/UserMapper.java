package net.javaguides.springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.javaguides.springboot.dto.request.CustomerRequest;
import net.javaguides.springboot.dto.request.UserRequest;
import net.javaguides.springboot.model.User;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Mapping(target = "firstName", source = "userRequest.firstName")
    @Mapping(target = "lastName", source = "userRequest.lastName")
    @Mapping(target = "email", source = "userRequest.email")
    @Mapping(target = "username", source = "userRequest.username")
    @Mapping(target = "address", source = "userRequest.address")
    @Mapping(target = "password", expression = "java(bCryptPasswordEncoder.encode(userRequest.getPassword()))")
    @Mapping(target = "created", expression = "java(java.time.Instant.now())")
    public abstract User mapUser(UserRequest userRequest);

    @Mapping(target = "firstName", source = "customerRequest.firstName")
    @Mapping(target = "lastName", source = "customerRequest.lastName")
    @Mapping(target = "email", source = "customerRequest.email")
    @Mapping(target = "username", source = "customerRequest.username")
    @Mapping(target = "password", expression = "java(bCryptPasswordEncoder.encode(customerRequest.getPassword()))")
    @Mapping(target = "companyName", source = "customerRequest.companyName")
    @Mapping(target = "address", source = "customerRequest.address")
    @Mapping(target = "city", source = "customerRequest.city")
    @Mapping(target = "region", source = "customerRequest.region")
    @Mapping(target = "postalCode", source = "customerRequest.postalCode")
    @Mapping(target = "country", source = "customerRequest.country")
    @Mapping(target = "phone", source = "customerRequest.phone")
    @Mapping(target = "created", expression = "java(java.time.Instant.now())")
    public abstract User mapCustomer(CustomerRequest customerRequest);
}
