package NL.MIW.SE2.Remco.YeOldeGunShoppe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Author: Remco Ketting
 * Purpose of program: a gun object to insert in the database
 */
@Entity
@Getter @Setter
public class Gun implements Comparable<Gun>{
    @Id @GeneratedValue
    private Long gunID;
    private String gunName;


    @ManyToOne
    private Ammo ammo;


    @Override
    public int compareTo(Gun otherGun) {

        return this.getAmmo().getAmmoName().compareTo(otherGun.getAmmo().getAmmoName());

    }
}
