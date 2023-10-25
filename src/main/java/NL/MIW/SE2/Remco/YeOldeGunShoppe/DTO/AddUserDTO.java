package NL.MIW.SE2.Remco.YeOldeGunShoppe.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Author: Remco Ketting
 * Purpose of program: shuttle data for new user form
 */@Getter @Setter
public class AddUserDTO {
    private String username;
    private String password;
    private String confirmPassword;


}
