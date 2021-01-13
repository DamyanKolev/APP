package net.javaguides.springboot.mapper;

import javax.annotation.processing.Generated;
import net.javaguides.springboot.dto.request.CustomerRequest;
import net.javaguides.springboot.dto.request.UserRequest;
import net.javaguides.springboot.model.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-13T00:20:12+0200",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public User mapUser(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userRequest.getFirstName() );
        user.setLastName( userRequest.getLastName() );
        user.setEmail( userRequest.getEmail() );
        user.setUsername( userRequest.getUsername() );
        user.setAddress( userRequest.getAddress() );

        user.setPassword( bCryptPasswordEncoder.encode(userRequest.getPassword()) );
        user.setCreated( java.time.Instant.now() );

        return user;
    }

    @Override
    public User mapCustomer(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( customerRequest.getFirstName() );
        user.setLastName( customerRequest.getLastName() );
        user.setEmail( customerRequest.getEmail() );
        user.setUsername( customerRequest.getUsername() );
        user.setCompanyName( customerRequest.getCompanyName() );
        user.setAddress( customerRequest.getAddress() );
        user.setCity( customerRequest.getCity() );
        user.setRegion( customerRequest.getRegion() );
        user.setPostalCode( customerRequest.getPostalCode() );
        user.setCountry( customerRequest.getCountry() );
        user.setPhone( customerRequest.getPhone() );

        user.setPassword( bCryptPasswordEncoder.encode(customerRequest.getPassword()) );
        user.setCreated( java.time.Instant.now() );

        return user;
    }
}
