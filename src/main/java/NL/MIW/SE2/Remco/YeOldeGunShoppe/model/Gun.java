package NL.MIW.SE2.Remco.YeOldeGunShoppe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToMany
    private Set<Attachment> attachments = new HashSet<>();


    @Override
    public int compareTo(Gun otherGun) {

        return this.getAmmo().getAmmoName().compareTo(otherGun.getAmmo().getAmmoName());

    }
    public String displayAttachments(){
        StringBuilder returnString = new StringBuilder();
        for (Attachment attachment : attachments) {
            returnString.append(attachment.getAttachmentName());
            returnString.append("\n");
        }
        return returnString.toString();
    }
}
