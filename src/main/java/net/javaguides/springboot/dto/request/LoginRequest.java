package net.javaguides.springboot.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 4799037873772743303L;
    
    private String username;
    private String password;
}
