package NL.MIW.SE2.Remco.YeOldeGunShoppe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
@Entity
@Getter @Setter
public class Ammo {
    @Id @GeneratedValue
    private Long ammoId;
    private String ammoName;
}
