package net.javaguides.springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.javaguides.springboot.dto.CustomerRequest;
import net.javaguides.springboot.dto.UserRequest;
import net.javaguides.springboot.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Mapping(target = "firstName", source = "userRequest.firstName")
    @Mapping(target = "lastName", source = "userRequest.lastName")
    @Mapping(target = "email", source = "userRequest.email")
    @Mapping(target = "username", source = "userRequest.username")
    @Mapping(target = "password", expression = "java(encryptPassword(userRequest))")
    @Mapping(target = "created", expression = "java(java.time.Instant.now())")
    @Mapping(target = "role", expression = "java(net.javaguides.springboot.model.Role.USER)")
    User mapUser(UserRequest userRequest);

    @Mapping(target = "firstName", source = "userRequest.firstName")
    @Mapping(target = "lastName", source = "userRequest.lastName")
    @Mapping(target = "email", source = "userRequest.email")
    @Mapping(target = "username", source = "userRequest.username")
    @Mapping(target = "password", expression = "java(encryptPassword(userRequest))")
    @Mapping(target = "companyName", source = "userRequest.companyName")
    @Mapping(target = "address", source = "userRequest.address")
    @Mapping(target = "city", source = "userRequest.city")
    @Mapping(target = "region", source = "userRequest.region")
    @Mapping(target = "postalCode", source = "userRequest.postalCode")
    @Mapping(target = "country", source = "userRequest.country")
    @Mapping(target = "phone", source = "userRequest.phone")
    @Mapping(target = "created", expression = "java(java.time.Instant.now())")
    @Mapping(target = "role", expression = "java(net.javaguides.springboot.model.Role.ADMIN)")
    User mapCustomer(CustomerRequest customerRequest);

    default String encryptPasswordCustomer(CustomerRequest customerRequest) {
        return bCryptPasswordEncoder.encode(customerRequest.getPassword());
    }
}
