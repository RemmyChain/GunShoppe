package NL.MIW.SE2.Remco.YeOldeGunShoppe.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Author: Remco Ketting
 * Purpose of program: ammunition object for use with firearms
 */
@Entity
@Getter @Setter
public class Ammo {
    @Id @GeneratedValue
    private Long ammoId;
    private String ammoName;

    @OneToMany(mappedBy = "ammo")
    private List<Gun> usedByGuns;


}
